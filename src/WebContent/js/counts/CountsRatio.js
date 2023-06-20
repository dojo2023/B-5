let lineCtx = document.getElementById("Chart");
        // 円グラフグラフの設定
        let lineConfig = {
          type: 'pie',
          data: {
            labels: ['Aさん', 'Bさん', 'Cさん', 'Dさん', 'Eさん', 'Fさん', 'Gさん'],
            datasets: [{
              label: 'Red',
              data: [22,35,41,23,64,12,43],
              backgroundColor: [
                "rgb(255, 99, 132)",
                "rgb(255, 159, 64)",
                "rgb(240, 240, 240)",
                "rgb(25, 110, 132)",
                "rgb(150, 200, 92)",
                "rgb(100, 80, 72)",
                "rgb(125, 99, 12)",
              ]
         
            }],
          },
          options: {
            
          },
        };
        let lineChart = new Chart(lineCtx, lineConfig);