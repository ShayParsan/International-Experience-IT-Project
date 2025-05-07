document.addEventListener('DOMContentLoaded', () => {
  const BASE_URL           = "http://localhost:8080";
  const collectionsSection = document.getElementById('collectionsSection');
  const nameRow            = document.getElementById('nameInputRow');
  const nameInput          = document.getElementById('collectionName');
  const user               = localStorage.getItem('user');

  // Show table only when logged in
  if (user) {
    collectionsSection.style.display = '';
    if (nameRow)   nameRow.style.display = 'none';
    if (nameInput) nameInput.disabled    = true;
  }

  // Fetch & display current user's collections
  async function getCollections() {
    try {
      const res = await fetch(`${BASE_URL}/collections`);
      if (!res.ok) throw new Error(res.statusText);
      const cols = await res.json();
      const tbody = document.querySelector("#collectionsTable tbody");
      tbody.innerHTML = "";

      cols.forEach(col => {
        if (user && col.name !== user) return;
        const tr = document.createElement("tr");
        tr.innerHTML = `
          <td>${col.id}</td>
          <td>${col.address}</td>
          <td>${col.number}</td>
          <td>
            <button class="button" onclick="openUpdateModal(${col.id})">Update</button>
            <button class="button" onclick="deleteCollection(${col.id})">Delete</button>
          </td>`;
        tbody.appendChild(tr);
      });
    } catch (err) {
      console.error("Error fetching collections:", err);
      alert("Failed to fetch collections.");
    }
  }

  // Add new collection
  document.getElementById("collectionForm").addEventListener("submit", async function(e) {
    e.preventDefault();
    const finalName = user || this.collectionName.value.trim();
    if (!finalName) {
      alert("Please provide a name or log in.");
      if (!user) openLogin();
      return;
    }
    const payload = {
      name:    finalName,
      address: this.collectionAddress.value.trim(),
      number:  this.collectionNumber.value.trim()
    };
    try {
      const res = await fetch(`${BASE_URL}/collections`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body:    JSON.stringify(payload)
      });
      if (!res.ok) throw new Error(await res.text());
      alert("Collection added!");
      this.reset();
      getCollections();
    } catch (err) {
      console.error("Error adding collection:", err);
      alert("Failed to add collection.");
    }
  });

  // Delete collection
  window.deleteCollection = async id => {
    if (!confirm("Are you sure?")) return;
    try {
      const res = await fetch(`${BASE_URL}/collections/${id}`, { method: "DELETE" });
      if (!res.ok) throw new Error(await res.text());
      alert("Deleted!");
      getCollections();
    } catch (err) {
      console.error("Error deleting:", err);
      alert("Failed to delete.");
    }
  };

  // Open update modal
  window.openUpdateModal = async id => {
    try {
      const res = await fetch(`${BASE_URL}/collections/${id}`);
      if (!res.ok) throw new Error(res.statusText);
      const col = await res.json();
      document.getElementById("updateCollectionId").value      = col.id;
      document.getElementById("updateCollectionAddress").value = col.address;
      document.getElementById("updateCollectionNumber").value  = col.number;
      document.getElementById("updateModal").style.display     = "block";
    } catch (err) {
      console.error("Error fetching:", err);
      alert("Failed to load details.");
    }
  };

  // Close update modal
  window.closeUpdateModal = () => {
    document.getElementById("updateModal").style.display = "none";
  };

  // Handle update form
  document.getElementById("updateCollectionForm").addEventListener("submit", async function(e) {
    e.preventDefault();
    const id = this.updateCollectionId.value;
    const updated = {
      name:    localStorage.getItem('user') || this.updateCollectionName.value,
      address: this.updateCollectionAddress.value,
      number:  this.updateCollectionNumber.value
    };
    try {
      const res = await fetch(`${BASE_URL}/collections/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body:    JSON.stringify(updated)
      });
      if (!res.ok) throw new Error(await res.text());
      alert("Updated!");
      closeUpdateModal();
      getCollections();
    } catch (err) {
      console.error("Error updating:", err);
      alert("Failed to update.");
    }
  });

  // Initial load
  if (user) getCollections();
});
