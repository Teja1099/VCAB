$(document).ready(function () {
    $('#login_link ').click(function () {
        $('#loginmodal').modal('toggle');
    });
    $('#reserve_link ').click(function () {
        $('#reserve').modal('toggle');
    });
    $('#cancel').click(function () {
        $('#loginmodal').modal('hide');
    });
    $('#dismiss').click(function () {
        $('#reserve').modal('hide');
    });
    $('#mycarousel').carousel({ interval: 1000 });
    $('#carouselbutton').click(function () {
        if ($('#carouselbutton').children('span').hasClass('fa-pause')) {
            $('#mycarousel').carousel('pause');
            $('#carouselbutton').children('span').removeClass('fa-pause');
            $('#carouselbutton').children('span').addClass('fa-play');
        }
        else {
            $('#mycarousel').carousel('cycle');
            $('#carouselbutton').children('span').removeClass('fa-play');
            $('#carouselbutton').children('span').addClass('fa-pause');
        }
    });
});