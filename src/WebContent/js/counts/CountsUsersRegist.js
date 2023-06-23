
var formObj = document.getElementById('submit');
var errorMessageObj = document.getElementById('error_message');
formObj.onsubmit = function() {
  if (!formObj.user_id.value || !formObj.password.value) {
    errorMessageObj.textContent = '※一致しません';
    return false;
  }
  errorMessageObj.textContent = null;
};


