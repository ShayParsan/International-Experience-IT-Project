const fakeSubmissions = [
    { name: "Lebo Mokoena" },
    { name: "Sipho Dlamini" },
    { name: "Anele Khumalo" },
    { name: "Thabo Ndlovu" },
    { name: "Zanele Mthembu" },
    { name: "Lerato Mahlangu" },
    { name: "Nomsa Sibanda" },
    { name: "Kagiso Maseko" },
    { name: "Tshepo Radebe" },
    { name: "Boitumelo Sithole" },
    { name: "Ayanda Nkosi" },
    { name: "Sibusiso Mthethwa" },
    { name: "Nthabiseng Molefe" },
    { name: "Karabo Dube" },
    { name: "Thuli Madonsela" },
    { name: "Mpho Phiri" },
    { name: "Andile Zulu" },
    { name: "Nomvula Zwane" },
    { name: "Tumi Mabaso" },
    { name: "Bonang Ncube" }
  ];
  
  // Give them random submissions (1–12 each)
  const expandedSubs = [];
  
  fakeSubmissions.forEach((user) => {
    const count = Math.floor(Math.random() * 12) + 1; // 1 to 12
    for (let i = 0; i < count; i++) {
      expandedSubs.push({ name: user.name });
    }
  });
  
  localStorage.setItem("volunteerSubmissions", JSON.stringify(expandedSubs));
  