
      function getTier(count) {
        if (count >= 10) return "PLATINUM";
        if (count >= 6) return "GOLD";
        if (count >= 3) return "SILVER";
        return "BRONZE";
      }

      document.addEventListener("DOMContentLoaded", () => {
        const submissions =
          JSON.parse(localStorage.getItem("volunteerSubmissions")) || [];

        const userStats = {};

        submissions.forEach((sub) => {
          if (!userStats[sub.name]) {
            userStats[sub.name] = 1;
          } else {
            userStats[sub.name]++;
          }
        });

        const sorted = Object.entries(userStats)
          .sort((a, b) => b[1] - a[1])
          .map(([name, count], index) => {
            return {
              rank: index + 1,
              name,
              count,
              tier: getTier(count),
            };
          });

        const tbody = document.getElementById("leaderboardBody");
        sorted.forEach((entry) => {
          const row = document.createElement("tr");
          row.innerHTML = `
            <td>${entry.rank}</td>
            <td>${entry.name}</td>
            <td>${entry.count}</td>
            <td>${entry.tier}</td>
          `;
          tbody.appendChild(row);
        });
      });
