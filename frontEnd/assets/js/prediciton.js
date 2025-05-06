document.addEventListener("DOMContentLoaded", () => {
    const daysInput = document.getElementById("daysInput");
    const loadBtn = document.getElementById("loadBtn");
    const ctx = document.getElementById("predictionChart").getContext("2d");
    let predictionChart = null;

    function drawChart(data, days) {
      const labels = data.map((i) => i.time);
      const values = data.map((i) => parseFloat(i.prediction));

      if (predictionChart) {
        predictionChart.data.labels = labels;
        predictionChart.data.datasets[0].data = values;
        predictionChart.options.plugins.title.text = `Next ${days}-Day Forecast`;
        predictionChart.update();
      } else {
        predictionChart = new Chart(ctx, {
          type: "line",
          data: {
            labels,
            datasets: [
              {
                label: "Prediction",
                data: values,
                borderColor: "rgba(75,192,192,1)",
                backgroundColor: "rgba(75,192,192,0.2)",
                fill: true,
              },
            ],
          },
          options: {
            animation: false,
            responsive: true,
            scales: {
              x: { title: { display: true, text: "Date" } },
              y: { title: { display: true, text: "Value" } },
            },
            plugins: {
              title: { display: true, text: `Next ${days}-Day Forecast` },
            },
          },
        });
      }
    }

    async function loadPredictions(days) {
      try {
        const res = await fetch(
          `http://127.0.0.1:5000/predictDays/${days}`,
          {
            mode: "cors",
          }
        );
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        const json = await res.json();

        // Save to localStorage
        localStorage.setItem(`prediction-${days}`, JSON.stringify(json));

        drawChart(json, days);
      } catch (err) {
        console.error("Error loading predictions:", err);
        alert("Failed to load predictions. Check console.");
      }
    }

    loadBtn.addEventListener("click", () => {
      const days = parseInt(daysInput.value, 10);
      const stored = localStorage.getItem(`prediction-${days}`);

      if (stored) {
        drawChart(JSON.parse(stored), days);
      } else {
        loadPredictions(days);
      }
    });

    // Auto-load from localStorage or fetch default 30-day forecast
    const defaultDays = parseInt(daysInput.value, 10);
    const cached = localStorage.getItem(`prediction-${defaultDays}`);
    if (cached) {
      drawChart(JSON.parse(cached), defaultDays);
    } else {
      loadPredictions(defaultDays);
    }
  });