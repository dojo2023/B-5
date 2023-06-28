

const end_name = document.querySelector(".nametrue").value;
const end_counts = document.querySelector(".countstrue").value;

const name_array =[];
const counts_array=[];
console.log("end_name:"+end_name);
console.log("end_counts:"+end_counts);

for(let i=0;i<=end_name;i++){
	const name = document.getElementById("name"+i).value;
	name_array[i]=name;
}
const diff= end_counts-end_name;

console.log(diff);
if(end_name != end_counts){
	for(let i=1;i<=diff;i++){
	let end_name_new = i+Number(end_name);
	name_array[end_name_new]="guest"+i;
	console.log("end_name+i:"+ end_name_new);
	}

}


for(let i=0;i<=end_counts;i++){
	const counts = document.getElementById("counts"+i).value;
	
	counts_array[i]=counts;
}


let lineCtx = document.getElementById("Chart");
        // 円グラフグラフの設定
     let lineConfig = {
          type: 'pie',
          data: {
            labels: name_array,
            datasets: [{
              label: 'Red',
              data: counts_array,
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