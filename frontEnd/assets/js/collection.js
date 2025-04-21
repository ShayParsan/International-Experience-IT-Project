const BASE_URL = "http://localhost:8080";

  // 1) Update login/register UI based on localStorage.user
  function updateLoginUI() {
    const user = localStorage.getItem('user');
    const loginBtn = document.getElementById('loginBtn');
    const registerBtn = document.getElementById('registerBtn');
    const nameInputRow = document.getElementById('nameInputRow');

    if (user) {
      loginBtn.innerText = 'Sign Out';
      loginBtn.onclick = () => {
        localStorage.removeItem('user');
        location.reload();
      };
      registerBtn.style.display = 'none';
      // hide manual name input if you always want to use the logged-in user
      if (nameInputRow) nameInputRow.style.display = 'none';
    } else {
      loginBtn.innerText = 'Sign In';
      loginBtn.onclick = openLogin; // assume you have this
      registerBtn.style.display = '';
      if (nameInputRow) nameInputRow.style.display = '';
    }
  }

  // 2) Fetch & render all collections
  async function getCollections() {
    try {
      const res = await fetch(`${BASE_URL}/collections`);
      if (!res.ok) throw new Error(res.statusText);
      const collections = await res.json();
      const tbody = document.querySelector("#collectionsTable tbody");
      tbody.innerHTML = "";
      collections.forEach(col => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
          <td>${col.id}</td>
          <td>${col.name}</td>
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

  // 3) Add a new collection
  document.getElementById("collectionForm").addEventListener("submit", async function(e) {
    e.preventDefault();
    const user = localStorage.getItem('user');
    // if logged in, use that as name; otherwise grab the name input
    const name = user || document.getElementById("collectionName").value.trim();
    if (!name) { 
      alert("Please provide a name or log in.");
      if (!user) openLogin();
      return;
    }
    const payload = {
      name,
      address: document.getElementById("collectionAddress").value.trim(),
      number: document.getElementById("collectionNumber").value.trim()
    };
    try {
      const res = await fetch(`${BASE_URL}/collections`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload)
      });
      if (!res.ok) throw new Error(res.statusText);
      alert("Collection added successfully!");
      this.reset();
      updateLoginUI(); // in case register/login buttons need toggling
      getCollections();
    } catch (err) {
      console.error("Error adding collection:", err);
      alert("Failed to add collection.");
    }
  });

  // 4) Delete a collection
  async function deleteCollection(id) {
    if (!confirm("Are you sure you want to delete this collection?")) return;
    try {
      const res = await fetch(`${BASE_URL}/collections/${id}`, { method: "DELETE" });
      if (!res.ok) throw new Error(res.statusText);
      alert("Collection deleted!");
      getCollections();
    } catch (err) {
      console.error("Error deleting collection:", err);
      alert("Failed to delete collection.");
    }
  }

  // 5) Open & populate update modal
  async function openUpdateModal(id) {
    try {
      const res = await fetch(`${BASE_URL}/collections/${id}`);
      if (!res.ok) throw new Error(res.statusText);
      const col = await res.json();
      document.getElementById("updateCollectionId").value       = col.id;
      document.getElementById("updateCollectionName").value     = col.name;
      document.getElementById("updateCollectionAddress").value  = col.address;
      document.getElementById("updateCollectionNumber").value   = col.number;
      document.getElementById("updateModal").style.display = "block";
    } catch (err) {
      console.error("Error fetching collection:", err);
      alert("Failed to fetch collection details.");
    }
  }

  function closeUpdateModal() {
    document.getElementById("updateModal").style.display = "none";
  }

  // 6) Handle the update form submission
  document.getElementById("updateCollectionForm").addEventListener("submit", async function(e) {
    e.preventDefault();
    const id = document.getElementById("updateCollectionId").value;
    const updated = {
      name: document.getElementById("updateCollectionName").value.trim(),
      address: document.getElementById("updateCollectionAddress").value.trim(),
      number: document.getElementById("updateCollectionNumber").value.trim()
    };
    try {
      const res = await fetch(`${BASE_URL}/collections/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(updated)
      });
      if (!res.ok) throw new Error(res.statusText);
      alert("Collection updated successfully!");
      closeUpdateModal();
      getCollections();
    } catch (err) {
      console.error("Error updating collection:", err);
      alert("Failed to update collection.");
    }
  });

