/**
 * 
 */


let counts = c;
console.log(c);
//HTMLのid値を使って以下のDOM要素を取得
for (let i = 1; i <= counts; i++) {
	const down = "down" + i;
	console.log(down);
	const downbutton = document.getElementById(down);
	const up = "up" + i;
	console.log(up);
	const upbutton = document.getElementById(up);
	const textbox = "textbox" + i;
	console.log(textbox);
	const text = document.getElementById(textbox);
	const reseti = "reset" + i;
	console.log(reseti);
	const reset = document.getElementById(reseti);


		//HTMLのid値を使って以下のDOM要素を取得



		//ボタンが押されたらカウント減
		downbutton.addEventListener('click', (event) => {


			//0以下にはならないようにする
			if (text.value >= 1) {
				text.value--;
			}
		});



		//ボタンが押されたらカウント増
		upbutton.addEventListener('click', (event) => {
			text.value++;
		});


		//ボタンがされたら0に戻る
		reset.addEventListener('click', (event) => {
			text.value = 0;
		});
	}
