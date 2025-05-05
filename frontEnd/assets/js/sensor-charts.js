let rawData = [];
      let chart, nitrateChart, phosphorusChart, phosphateChart, ammoniumChart;
    
      function parseDateString(str) {
        return new Date(str);
      }
    
      function groupByDate(data, key, period = 'daily') {
        const groups = {};
        data.forEach(r => {
          const d = new Date(r['Sample Start Date']);
          let periodKey;
          
          if (period === 'monthly') {
            periodKey = `${d.getFullYear()}-${d.getMonth() + 1}`;
          } else if (period === 'yearly') {
            periodKey = `${d.getFullYear()}`;
          } else { // 'daily'
            periodKey = d.toISOString().split('T')[0];
          }
    
          const value = parseFloat(r[key]);
          if (!isNaN(value)) {
            if (!groups[periodKey]) groups[periodKey] = [];
            groups[periodKey].push(value);
          }
        });
    
        return Object.entries(groups).map(([period, vals]) => {
          const avg = vals.reduce((a, b) => a + b, 0) / vals.length;
          return { period, value: avg };
        }).sort((a, b) => new Date(a.period) - new Date(b.period));
      }
      function toTransparent(color, alpha) {

  const temp = document.createElement("div");
  temp.style.color = color;
  document.body.appendChild(temp);

  const rgb = window.getComputedStyle(temp).color;
  document.body.removeChild(temp);

  return rgb.replace("rgb(", "rgba(").replace(")", `, ${alpha})`);
}

function createLineChart(ctx, label, lineColor, yAxisID) {
  return new Chart(ctx, {
    type: "line",
    data: {
      labels: [],
      datasets: [{
        label,
        data: [],
        borderColor: lineColor,
        backgroundColor: toTransparent(lineColor, 0.1),  
        fill: true,
        yAxisID
      }]
    },
    options: {
      responsive: true,
      scales: {
        [yAxisID]: {
          title: { display: true, text: label }
        }
      },
      plugins: {
        title: { display: true, text: label + " over Time" }
      }
    }
  });
}


    
      function updateSingleChart(chartInstance, dataPoints) {
        chartInstance.data.labels = dataPoints.map(pt => pt.period);
        chartInstance.data.datasets[0].data = dataPoints.map(pt => pt.value);
        chartInstance.update();
      }
    
      function applyFilters() {
        const start = document.getElementById('startDate').value;
        const end = document.getElementById('endDate').value;
        const agg = document.getElementById('aggSelect').value;
    
        let filtered = rawData;
        if (start) {
          const d0 = new Date(start);
          filtered = filtered.filter(r => parseDateString(r['Sample Start Date']) >= d0);
        }
        if (end) {
          const d1 = new Date(end);
          d1.setHours(23, 59, 59, 999);
          filtered = filtered.filter(r => parseDateString(r['Sample Start Date']) <= d1);
        }
    
        const makePoints = (key) => {
          if (agg === 'daily') {
            return groupByDate(filtered, key, 'daily').map(g => ({ period: g.period, value: g.value }));
          } else if (agg === 'monthly') {
            return groupByDate(filtered, key, 'monthly').map(g => ({ period: g.period, value: g.value }));
          } else if (agg === 'yearly') {
            return groupByDate(filtered, key, 'yearly').map(g => ({ period: g.period, value: g.value }));
          } else {
            return filtered.map(r => {
              const d = parseDateString(r['Sample Start Date']);
              return { period: d.toLocaleDateString() + ' ' + d.toLocaleTimeString(), value: parseFloat(r[key]) };
            }).filter(p => !isNaN(p.value));
          }
        };
    
        updateSingleChart(chart, makePoints('TEMP'));
        updateSingleChart(nitrateChart, makePoints('NO3+NO2-N-Diss-Water (NITRATE + NITRITE NITROGEN) (mg/L) Result'));
        updateSingleChart(phosphorusChart, makePoints('P-Tot-Water (TOTAL PHOSPHORUS) (mg/L) Result'));
        updateSingleChart(phosphateChart, makePoints('PO4-P-Diss-Water (ORTHO PHOSPHATE AS PHOSPHORUS) (mg/L) Result'));
        updateSingleChart(ammoniumChart, makePoints('NH4-N-Diss-Water (AMMONIUM NITROGEN) (mg/L) Result'));
      }
    
      document.addEventListener("DOMContentLoaded", function () {
        const excelUrl = 'https://raw.githubusercontent.com/AdrianGriesel/DATA/main/Hartbeespoort%20Dam%20wq%20data.xlsx';
        fetch(excelUrl)
          .then(res => res.arrayBuffer())
          .then(ab => {
            const wb = XLSX.read(ab, { type: 'array' });
            const ws = wb.Sheets[wb.SheetNames[0]];
            rawData = XLSX.utils.sheet_to_json(ws, { raw: false })
              .filter(r => r['Sample Start Date'])
              .sort((a, b) => new Date(a['Sample Start Date']) - new Date(b['Sample Start Date']));
    
            chart = createLineChart(document.getElementById("combinedChart").getContext('2d'), "Temperature (°C)", "red", "y-temp");
            nitrateChart = createLineChart(document.getElementById("nitrateChart").getContext('2d'), "Nitrate + Nitrite (mg/L)", "blue", "y-nitrate");
            phosphorusChart = createLineChart(document.getElementById("phosphorusChart").getContext('2d'), "Total Phosphorus (mg/L)", "green", "y-phos");
            phosphateChart = createLineChart(document.getElementById("phosphateChart").getContext('2d'), "Ortho Phosphate (mg/L)", "orange", "y-po4");
            ammoniumChart = createLineChart(document.getElementById("ammoniumChart").getContext('2d'), "Ammonium (mg/L)", "purple", "y-nh4");
    
            applyFilters();
          })
          .catch(err => console.error("Error loading data", err));
    
        document.getElementById('applyBtn').addEventListener('click', applyFilters);
    
        
        document.getElementById('resetBtn').addEventListener('click', function () {
          document.getElementById('startDate').value = '';
          document.getElementById('endDate').value = '';
          document.getElementById('aggSelect').value = 'none';
          applyFilters();
        });
      });
    
      
      function openLogin(){document.getElementById('loginModal').style.display='block';}
      function closeLogin(){document.getElementById('loginModal').style.display='none';}
      function openRegister(){document.getElementById('registerModal').style.display='block';}
      function closeRegister(){document.getElementById('registerModal').style.display='none';}