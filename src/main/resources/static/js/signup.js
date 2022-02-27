'use strict';

/*[ signup Validate ]*/
const inputSignup = document.querySelector('#signupForm');
const checkUsername = document.getElementById('username');
const setPassword = document.getElementById('password');
const passwordCheck = document.getElementById('password-check');
const inputValidate2 = document.querySelectorAll('.signup-wrap-input.validate-input');
const inputArr2 = [checkUsername, setPassword, passwordCheck];

inputSignup.addEventListener('submit', (event) => {
    /*회원가입 validation참고
    if(checkRequred([username, password])){
        checkPasswordMatch(password1, password2)
    }*/
    for(let i=0; i<inputArr2.length; i++) {
        if(inputArr2[i].value.trim() === ''){
            event.preventDefault();
            inputValidate2[i].classList.add('alert-validate');
        }
    }
});