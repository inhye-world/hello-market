'use strict';

/*[ login Validate ]*/
const inputData = document.querySelector('#loginForm');
const username = document.getElementById('username');
const password = document.getElementById('password');
const inputValidate = document.querySelectorAll('.wrap-input.validate-input');
const inputArr = [username, password];

inputData.addEventListener('submit', (event) => {
    for(let i=0; i<inputArr.length; i++) {
        if(inputArr[i].value.trim() === ''){
            event.preventDefault();
            inputValidate[i].classList.add('alert-validate');
        }
    }
});

inputValidate.forEach((click) => {
    click.addEventListener('click', (event) => {
        event.currentTarget.classList.remove('alert-validate');
    })
});

/*[ Show pass ]*/
const btnShowPass = document.querySelector('.btn-show-pass');
const btnShowPassi = document.querySelector('.btn-show-pass .fa-eye');

let showPass = 0;
btnShowPass.addEventListener('click', (event) => {
    if(showPass == 0) {
        btnShowPass.nextElementSibling.setAttribute('type','text');
        btnShowPassi.classList.remove('fa-eye');
        btnShowPassi.classList.add('fa-eye-slash');
        showPass = 1;
    }
    else {
        btnShowPass.nextElementSibling.setAttribute('type','password');
        btnShowPassi.classList.remove('fa-eye-slash');
        btnShowPassi.classList.add('fa-eye');
        showPass = 0;
    }

});
