
let lineCtx = document.getElementById("Chart");
        // 円グラフグラフの設定
        let lineConfig = {
          type: 'pie',
          data: {
            labels: name,
            datasets: [{
              label: 'Red',
              data: countscups,
              backgroundColor: [
                "rgb(255, 99, 132)",
                "rgb(255, 159, 64)",
                "rgb(240, 240, 240)",
                "rgb(25, 110, 132)",
                "rgb(150, 200, 92)",
                "rgb(100, 80, 72)",
                "rgb(125, 99, 12)",
                "rgb(255, 129, 132)",
                "rgb(275, 159, 64)",
                "rgb(240, 20, 240)",
              ]
         
            }],
          },
          options: {
            
          },
        };
        let lineChart = new Chart(lineCtx, lineConfig);