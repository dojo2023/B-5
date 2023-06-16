//-選択-のプルダウンを生成
function first_option(){
    const first = document.createElement('option');
    first.textContent = '-選択-';

    return first;
}
//引数に指定されたノードをすべて削除する
function optionClear(node){
    const options = document.querySelectorAll(node);
    options.forEach(option =>{
        option.remove();
    })
}
// 1分類のプルダウンを生成
first_categories.forEach(first_category => {
    const option = document.createElement('option');
    option.textContent = first_category;

    first_categories_select.appendChild(option);
});
//2分類と4分類のプルダウンを生成
first_categories_select.addEventListener('change', () => {
    //2分類のプルダウンを初期化し有効化
    optionClear('#kind > option');
    second_categories_select.appendChild(first_option());
    second_categories_select.disabled = false;
    //4分類のプルダウンを初期化し有効化
    optionClear('#from > option');
    forth_categories_select.appendChild(first_option());
    forth_categories_select.disabled = false;
    //1分類が未選択の場合2分類と4分類をはじく
    if(first_categories_select.value == '-選択-'){
        second_categories_select.disabled = true;
        forth_categories_select.disabled = true;
        return;
    }
    //1分類の値を元に2分類の値を格納
    second_categories.forEach(second_category => {
        if(first_categories_select.value == second_category.first_category){
            const option = document.createElement('option');
            option.textContent = second_category.name;

            second_categories_select.appendChild(option);
        }
    });
    //1分類の値を元に4分類の値を格納
    forth_categories.forEach(forth_category => {
        if(first_categories_select.value == forth_category.first_category){
            const option = document.createElement('option');
            option.textContent = forth_category.name;

            forth_categories_select.appendChild(option);
        }
    });
});