     const BASE_URL = "http://localhost:8080";

      function updateLoginUI() {
        const user = localStorage.getItem('user');
        const loginBtn = document.getElementById('loginBtn');
        const registerBtn = document.getElementById('registerBtn');
        if (user) {
          loginBtn.innerText = 'Sign Out';
          loginBtn.onclick = () => { localStorage.removeItem('user'); location.reload(); };
          registerBtn.style.display = 'none';
        }
      }

      document.addEventListener('DOMContentLoaded', () => {
        updateLoginUI();

        document.getElementById('dropOffForm').addEventListener('submit', async function(e) {
          e.preventDefault();
          const user = localStorage.getItem('user');
          if (!user) { alert('Please log in to search.'); openLogin(); return; }
          const dropAmount = parseFloat(document.getElementById('dropAmount').value);
          if (isNaN(dropAmount)) { alert('Enter a valid amount.'); return; }

          try {
            const res = await fetch(`${BASE_URL}/collections`);
            if (!res.ok) throw new Error('Fetch failed');
            const collections = await res.json();

            const sorted = collections
              .map(c => ({ ...c, diff: Math.abs(parseFloat(c.number) - dropAmount) }))
              .sort((a, b) => a.diff - b.diff);

            const tbody = document.querySelector('#resultsTable tbody');
            tbody.innerHTML = '';
            if (!sorted.length) {
              tbody.innerHTML = '<tr><td colspan="5">No active collections found.</td></tr>';
              return;
            }
            sorted.slice(0,5).forEach(c => {
              const row = document.createElement('tr');
              row.innerHTML = `
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.address}</td>
                <td>${c.number}</td>
                <td>${c.diff}</td>`;
              tbody.appendChild(row);
            });
          } catch (error) {
            console.error('Error fetching collections:', error);
            alert('Could not fetch collections.');
          }
        });
      });
