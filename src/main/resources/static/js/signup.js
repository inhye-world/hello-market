'use strict';

/*[ signup Validate ]*/
const inputSignup = document.querySelector('#signupForm');
const checkUsername = document.getElementById('username');
const setPassword = document.getElementById('password');
const passwordCheck = document.getElementById('password-check');
const inputValidate2 = document.querySelectorAll('.wrap-input.validate-input');
const inputArr2 = [checkUsername, setPassword, passwordCheck];

inputSignup.addEventListener('submit', (event) => {
    for(let i=0; i<inputArr2.length; i++) {
        if(inputArr2[i].value.trim() === ''){
            event.preventDefault();
            inputValidate2[i].classList.add('alert-validate');
        }
    }
});

inputValidate2.forEach((click) => {
    click.addEventListener('click', (event) => {
        event.currentTarget.classList.remove('alert-validate');
    })
});

/*[ Show pass ]*/
const btnShowPass = document.querySelector('.btn-show-pass');
const btnShowPassi = document.querySelector('.btn-show-pass .fa-eye');
const btnShowPassChk = document.querySelector('.btn-show-pass-chk');
const btnShowPassChki = document.querySelector('.btn-show-pass-chk .fa-eye');

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

btnShowPassChk.addEventListener('click', (event) => {
    if(showPass == 0) {
        btnShowPassChk.nextElementSibling.setAttribute('type','text');
        btnShowPassChki.classList.remove('fa-eye');
        btnShowPassChki.classList.add('fa-eye-slash');
        showPass = 1;
    }
    else {
        btnShowPassChk.nextElementSibling.setAttribute('type','password');
        btnShowPassChki.classList.remove('fa-eye-slash');
        btnShowPassChki.classList.add('fa-eye');
        showPass = 0;
    }

});