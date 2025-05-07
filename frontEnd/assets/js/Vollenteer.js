
      document.addEventListener("DOMContentLoaded", () => {
        const user = localStorage.getItem("user");
        const nameInput = document.getElementById("volunteerName");
        if (user && nameInput) nameInput.value = user;
      });
 

      let submissions =
        JSON.parse(localStorage.getItem("volunteerSubmissions")) || [];

      function awardDefaultReward() {
        const event = document.getElementById("volunteerEvent").value;
        let rank, name;
        if (event === "cleanUpEvent") {
          rank = "BRONZE";
          name = "Community Cleanup Badge";
        } else {
          rank = "SILVER";
          name = "Hyacinth Delivery Badge";
        }
        const rewards = JSON.parse(localStorage.getItem("userRewards")) || [];
        rewards.push({
          id: Date.now(),
          name,
          description: `Awarded for ${
            event === "cleanUpEvent" ? "cleanup" : "delivery"
          }.`,
          date: new Date().toISOString().slice(0, 10),
          rank,
        });
        localStorage.setItem("userRewards", JSON.stringify(rewards));
      }

      document
        .getElementById("volunteerForm")
        .addEventListener("submit", function (e) {
          e.preventDefault();
          const submission = {
            name: document.getElementById("volunteerName").value.trim(),
            email: document.getElementById("volunteerEmail").value.trim(),
            event: document.getElementById("volunteerEvent").value,
            message: document.getElementById("volunteerMessage").value.trim(),
            timestamp: new Date().toISOString(),
          };
          submissions.push(submission);
          localStorage.setItem(
            "volunteerSubmissions",
            JSON.stringify(submissions)
          );
          awardDefaultReward();
          this.reset();
          alert(
            "Thank you for volunteering! Check your Rewards page to see your new badge."
          );
        });
