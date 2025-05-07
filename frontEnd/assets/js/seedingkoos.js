// seedKoosData.js

document.addEventListener("DOMContentLoaded", function () {
    if (localStorage.getItem('user') === 'Koos' 
        && !localStorage.getItem('__koos_seeded')) {
  
      // Dummy volunteer submissions
      const submissions = [
        {
          name: "Koos",
          email: "koos@example.com",
          event: "cleanUpEvent",
          message: "Ready to clean at sunrise!",
          timestamp: new Date().toISOString(),
        },
        {
          name: "Koos",
          email: "koos@example.com",
          event: "hyacinthDelivery",
          message: "Delivered 5 bags today.",
          timestamp: new Date(Date.now() - 86400000).toISOString(), // 1 day ago
        },
        {
          name: "Koos",
          email: "koos@example.com",
          event: "cleanUpEvent",
          message: "Joined the riverside cleanup!",
          timestamp: new Date(Date.now() - 2 * 86400000).toISOString(), // 2 days ago
        },
        {
          name: "Koos",
          email: "koos@example.com",
          event: "hyacinthDelivery",
          message: "Dropped off 7 bags at HQ.",
          timestamp: new Date(Date.now() - 3 * 86400000).toISOString(), // 3 days ago
        },
        {
          name: "Koos",
          email: "koos@example.com",
          event: "cleanUpEvent",
          message: "Helping out the local team today.",
          timestamp: new Date(Date.now() - 4 * 86400000).toISOString(), // 4 days ago
        },
      ];
      localStorage.setItem('volunteerSubmissions', JSON.stringify(submissions));
  
      // Dummy user rewards
      const rewards = [
        {
          id: 1,
          name: "Community Cleanup Badge",
          description: "Awarded for cleanup at sunrise.",
          date: new Date().toISOString().slice(0, 10),
          rank: "BRONZE",
        },
        {
          id: 2,
          name: "Hyacinth Delivery Badge",
          description: "Delivered 5 bags today.",
          date: new Date(Date.now() - 86400000).toISOString().slice(0, 10),
          rank: "SILVER",
        },
        {
          id: 3,
          name: "Riverside Cleanup Star",
          description: "Joined riverside cleanup event.",
          date: new Date(Date.now() - 2 * 86400000).toISOString().slice(0, 10),
          rank: "BRONZE",
        },
        {
          id: 4,
          name: "Hyacinth Hero Medal",
          description: "Dropped off 7 bags at HQ.",
          date: new Date(Date.now() - 3 * 86400000).toISOString().slice(0, 10),
          rank: "SILVER",
        },
        {
          id: 5,
          name: "Local Team Supporter",
          description: "Helped the local cleanup team.",
          date: new Date(Date.now() - 4 * 86400000).toISOString().slice(0, 10),
          rank: "BRONZE",
        },
      ];
      localStorage.setItem('userRewards', JSON.stringify(rewards));
  
      // Mark seeding done
      localStorage.setItem('__koos_seeded', 'true');
  
      console.log("Koos data seeded with 10 entries!");
    }
  });
  