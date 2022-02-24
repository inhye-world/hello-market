'use strict';


    /*==================================================================
    [ Validate ]*/
    const inputData = document.querySelector('#loginForm');
    const username = document.getElementById('username');
    const password = document.getElementById('password');
    const inputValidate = document.querySelectorAll('.wrap-input.validate-input');
    const inputArr = [username, password];

    inputData.addEventListener('submit', (event) => {
        /*회원가입 validation참고
        if(checkRequred([username, password])){
            checkPasswordMatch(password1, password2)
        }*/
        for(let i=0; i<inputArr.length; i++) {
            if(inputArr[i].value.trim() === ''){
                event.preventDefault();
                inputValidate[i].classList.add('alert-validate');
            }
        }
    });

    /*[ Show pass ]*/
    let showPass = 0;
    $('.btn-show-pass').on('click', function(){
        if(showPass == 0) {
            $(this).next('input').attr('type','text');
            $(this).find('i').removeClass('fa-eye');
            $(this).find('i').addClass('fa-eye-slash');
            showPass = 1;
        }
        else {
            $(this).next('input').attr('type','password');
            $(this).find('i').removeClass('fa-eye-slash');
            $(this).find('i').addClass('fa-eye');
            showPass = 0;
        }

    });
