//配列の宣言
//ここでは10組、１種類のデータを受け取ると仮定して設定する
//All_memberで人数分の箱を用意し、users_memberは名前をあてはめて、残りのゲストは１から番号を振る
//[]の中はカウント回数
let data0 = [];
let data1 = [];
let data2 = [];
let data3 = [];
let data4 = [];
let data5 = [];
let data6 = [];
let data7 = [];
let data8 = [];
let data9 = [];
//各要素へのデータの格納今回はindexによる
data0[0] = document.getElementById('0data0').value;
data1[0] = document.getElementById("1data0").value;
data2[0] = document.getElementById("2data0").value;
data3[0] = document.getElementById("3data0").value;
data4[0] = document.getElementById("4data0").value;
data5[0] = document.getElementById("5data0").value;
data6[0] = document.getElementById('6data0').value;
data7[0] = document.getElementById("7data0").value;
data8[0] = document.getElementById("8data0").value;
data9[0] = document.getElementById("9data0").value;
data10[0] = document.getElementById("10data0").value;


let lineCtx = document.getElementById("Chart");
        // 円グラフグラフの設定
        let lineConfig = {
          type: 'pie',
          data: {
            labels: ['Aさん', 'Bさん', 'Cさん', 'Dさん', 'Eさん', 'Fさん', 'Gさん', 'Hさん', 'Iさん', 'Jさん'],
            datasets: [{
              label: 'Red',
              data: [data0[0],data1[0],data2[0],data3[0],data4[0],data5[0],data6[0],data7[0],data8[0],data9[0],data10[0]],
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