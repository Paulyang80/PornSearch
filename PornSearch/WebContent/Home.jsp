<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
        <style>
            *{
                margin:0;
                padding:0;
                font-family:'Roboto',sans-serif;
            }
            .container{
                width:100%;
                height:100vh;
                background-image: linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7)),url(home.jpg);
                background-position: center;
                background-size: cover;
                padding-left: 8%;
                padding-right: 8%;
                box-sizing:border-box;
            }
            .navbar{
                height:12%;
                display:flex;
                align-items:center;

            }
            .logo{
                width: 150px;
                cursor:pointer;
            }
            .menu-icon{
                width:50px;
                cursor:pointer;
            }
            nav{
                flex: 1;
                text-align: right;
            }
            nav ul li{
                list-style: none;
                display:inline-block;
                margin-left: 60px;
            }
            nav ul li a{
                text-decoration:none;
                color:#fff;
                font-size:13px;
            }
            .row{
                display:flex;
                height:88%;
                align-items: center;
            }
            .col{
                flex-basis: 50%;
            }
            h1{
                color:#fff;
                font-size:100px;
            }
            p{
                color:#fff;
                font-size:15px;
                line-height:15px;
            }
            .card{
                width:200px;
                height:230px;
                display:inline-block;
                border-radius:10px;
                padding: 15px 25px;
                box-sizing:border-box;
                cursor:pointer;
                margin:10px 15px;
                background-position:center;
                background-size: cover;
                transition:transform 0.5s ;
            }
            .card1{
                background-image: url(card1.jfif);
            }

            .card2{
                background-image: url(card2.jpg);
            }

            .card3{
                background-image: url(card3.jpg);
            }

            .card4{
                background-image: url(card4.jpg);
            }

            .card:hover{
                transform: translateY(-10px);
            }

            .search-box{
                width:100%;
                position:relative;
                display: flex;
                padding: 25px;
            }

            .search{
                width:50%;
                border: 3px solid #FF9900;
                border-right: none;
                padding: 5px;
                height: 20px;
                outline: none;
                color:#fff;
            }

            .search:focus{
                color:#000;
                box-shadow: 0 0 5px #FF9900;
            }

            .search-btn{
                width: 40px;
                height: 36px;
                border: 1px solid #FF9900;
                background:#FF9900;
                text-align: center;
                color:#fff;
                border-radius: 0 5px 5px 0;
                cursor: pointer;
                font-size:20px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="navbar">
                <a href="https://cn.pornhub.com/">
                    <img src="PornLogo.png" alt="logo" class="logo">
                </a>
                <nav>
                    <ul>
                        <li><a href="https://www.google.com.tw/?gws_rd=cr&ei=CctOUr7-CsTlkgXcr4C4CA">HOME</a></li>
                        <li><a href="https://cn.nytimes.com/opinion/20201208/pornhub-rape-trafficking/zh-hant/">PORNHUB</a></li>
                        <li><a href="https://crossing.cw.com.tw/article/13182">Nth ROOM</a></li>
                        <li><a href="https://www.equalitynow.org/learn_more_sexual_violence_in_india">Sex Violence</a></li>
                        <li><a href="https://www.bbc.com/zhongwen/trad/world-45224235">#MeToo</a></li>
                    </ul>
                </nav>
                <!-- <img src="menu.png" alt="menu-icon" class="menu-icon"> -->
            </div>
            <div class="row">
                <div class="col">
                    <h1>PornSearch</h1>
                    <p>
                        We aim to search out the truth and to raise awareness of the public to face this issue together.
                    </p>
                    <form action='${requestUri}' method='get'>
                        <div class="search-box">
                            <input type="text" class="search" name="keyword" >
                            <button type="submit" class="search-btn">
                                <i class="fa fa-search" aria-hidden="true"></i>
                            </button>
                    	</div>
                    </form>
                </div>
                <div class="col">
                    <div class="card card1">
                        <h5>Nth Room</h5>
                        <p>

                        </p>
                    </div>
                    <div class="card card2">
                        <h5>Pornhub</h5>
                        <p>

                        </p>
                    </div>
                    <div class="card card3">
                        <h5>Sexual Violence in India</h5>
                        <p>

                        </p>
                    </div>
                    <div class="card card4">
                        <h5>#MeToo</h5>
                        <p>

                        </p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>