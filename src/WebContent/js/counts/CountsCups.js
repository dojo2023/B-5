/**
 * 
 */

<<<<<<< Updated upstream
let counts = c ;
console.log(c);
  //HTMLのid値を使って以下のDOM要素を取得
  for(let  i=1;i<= counts ;i++){
	  const down = "down"+i;
	  console.log(down);
	  const downbutton = document.getElementById(down);
	  const up = "up"+i;
	  console.log(up);
	  const upbutton = document.getElementById(up);
	  const textbox = "textbox"+i;
	  console.log(textbox);
	  const text = document.getElementById(textbox);
	  const reseti = "reset"+i;
	  console.log(reseti);
	  const reset = document.getElementById(reseti);
	  downbutton .addEventListener('click', (event) => {
=======
  //HTMLのid値を使って以下のDOM要素を取得
  const downbutton1 = document.getElementById('down1');
  const downbutton2 = document.getElementById('down2');
  const downbutton3 = document.getElementById('down3');
  const downbutton4 = document.getElementById('down4');
  const downbutton5 = document.getElementById('down5');

  
  const upbutton1 = document.getElementById('up1');
  const upbutton2 = document.getElementById('up2');
  const upbutton3 = document.getElementById('up3');
  const upbutton4 = document.getElementById('up4');
  const upbutton5 = document.getElementById('up5');
  
  const text1 = document.getElementById('textbox1');
  const text2 = document.getElementById('textbox2');
  const text3 = document.getElementById('textbox3');
  const text4 = document.getElementById('textbox4');
  const text5 = document.getElementById('textbox5');
  
  const reset1 = document.getElementById('reset1');
  const reset2 = document.getElementById('reset2');
  const reset3 = document.getElementById('reset3');
  const reset4 = document.getElementById('reset4');
  const reset5 = document.getElementById('reset5');

  
  
  //ボタンが押されたらカウント減
  downbutton1.addEventListener('click', (event) => {
>>>>>>> Stashed changes

  //0以下にはならないようにする
  if(text1.value >= 1) {
    text1.value--;
  }
  });
<<<<<<< Updated upstream
  
  
  //ボタンが押されたらカウント増
  upbutton.addEventListener('click', (event) => {
    text.value++;
  });


  //ボタンがされたら0に戻る
  reset.addEventListener('click', (event) => {
    text.value = 0;
  });
  }
  
 
=======
  downbutton2.addEventListener('click', (event) => {

  //0以下にはならないようにする

  if(text2.value >= 1) {
    text2.value--;
  }
  });
	
  	downbutton3.addEventListener('click', (event) => {

  //0以下にはならないようにする
  if(text3.value >= 1) {
    text3.value--;
  }
  });
  downbutton4.addEventListener('click', (event) => {

  //0以下にはならないようにする

  if(text4.value >= 1) {
    text4.value--;
  }
  });
 downbutton5.addEventListener('click', (event) => {

  //0以下にはならないようにする

  if(text5.value >= 1) {
    text5.value--;
  }
  });
  
  
  //ボタンが押されたらカウント増
  upbutton1.addEventListener('click', (event) => {
    text1.value++;
  })
  upbutton2.addEventListener('click', (event) => {
    text2.value++;
  })
  upbutton3.addEventListener('click', (event) => {
    text3.value++;
  })
  upbutton4.addEventListener('click', (event) => {
    text4.value++;
  })
  upbutton5.addEventListener('click', (event) => {
    text5.value++;
  })




  //ボタンがされたら0に戻る
  reset1.addEventListener('click', (event) => {
    text1.value = 0;
  })
  reset2.addEventListener('click', (event) => {
    text2.value = 0;
  })
  reset3.addEventListener('click', (event) => {
    text3.value = 0;
  })
  reset4.addEventListener('click', (event) => {
    text4.value = 0;
  })
  reset5.addEventListener('click', (event) => {
    text5.value = 0;
  })


>>>>>>> Stashed changes
