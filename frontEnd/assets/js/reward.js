

// Render stored rewards
function loadLocalRewards() {
  const tbody = document.querySelector("#rewardsTable tbody");
  tbody.innerHTML = "";
  const rewards = JSON.parse(localStorage.getItem("userRewards")) || [];
  if (rewards.length === 0) {
    tbody.innerHTML =
      '<tr><td colspan="6">No rewards earned yet.</td></tr>';
    return;
  }
  rewards.forEach((r) => {
    const tr = document.createElement("tr");
    tr.innerHTML = `
      <td>${r.id}</td>
      <td>${r.name}</td>
      <td>${r.description}</td>
      <td>${r.date}</td>
      <td>${r.rank}</td>
      <td><button class="button" onclick="deleteLocalReward(${r.id})">Delete</button></td>
    `;
    tbody.appendChild(tr);
  });
}

// Delete a reward
function deleteLocalReward(id) {
  let rewards = JSON.parse(localStorage.getItem("userRewards")) || [];
  rewards = rewards.filter((r) => r.id !== id);
  localStorage.setItem("userRewards", JSON.stringify(rewards));
  loadLocalRewards();
}

