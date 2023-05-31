$(document).ready(function(){
    $("#header").load("header.html", function() {

        // 로고
        $('#logo').click(function(){
            location.href = "./boardRecruitment.html?board=1";
        })

        // 로그인/로그아웃
        if (localStorage.getItem('isLogin')) {
            $('#username').text(localStorage.getItem('username'));
            $('#welcome').text('님 환영합니다!');
            $('#login-logout-button').text('로그아웃');
        }

        $('#login-logout-button').click(function(){
            if (!localStorage.getItem('isLogin')) {
                location.href = "./Login.html";
            } else {
                alert(`로그아웃 되었습니다.`);
                $('#username').text('');
                $('#welcome').text('');
                $('#login-logout-button').text('로그인');
                localStorage.removeItem('isLogin');
                if (location.href.includes('profile.html')) {
                    location.href = "./boardRecruitment.html?board=1";
                }
            }
        })

        // 메뉴 스타일
        $('.menu').css('text-decoration', 'none');

        $('.menu').click(function(){
            $('.menu').removeClass("choose");
            $('.menu').css('color', '#848484');
            $(this).addClass("choose");
            $(this).css('color', 'black');
        });

        $('.menu').hover(
            function () {
                $(this).css('backgroundColor', '#e9ecef');
            },
            function () {
                $(this).css('backgroundColor', 'white');
            }
        );

        const urlParams = new URLSearchParams(window.location.search);
        let board = urlParams.get('board');

        if (location.href.includes('boardRecruitment.html')) {
            board = 1;
        } else if (location.href.includes('QnABoard.html')) {
            board = 2;
        } else if (location.href.includes('ProofShot.html')) {
            board = 3;
        } else if (location.href.includes('ReviewBoard.html')) {
            board = 4;
        } else if (location.href.includes('profile.html')) {
            board = 9;
        }

        if (board <= 8) {
            const menuElementList = $('.menu');
            menuElementList.eq((board-1) % 4).addClass('choose');
            menuElementList.eq((board-1) % 4).css('color', 'black');
        }
    });
})