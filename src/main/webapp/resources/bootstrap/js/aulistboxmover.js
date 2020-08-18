jQuery(function ($) {
    $("#left").bind("click", function () {
        var options = $("#lstRight option:selected");
        for (var i = 0; i < options.length; i++) {
            var opt = $(options[i]).clone();
            $(options[i]).remove();
            $("#lstLeft").append(opt);
        }
    });

    $("#right").bind("click", function () {
        var options = $("#lstLeft option:selected");
        for (var i = 0; i < options.length; i++) {
            var opt = $(options[i]).clone();
            $(options[i]).remove();
            $("#lstRight").append(opt);
        }
    });

    $("#lstLeft").bind("dblclick", function () {
        var options = $("#lstLeft option:selected");
        for (var i = 0; i < options.length; i++) {
            var opt = $(options[i]).clone();
            $(options[i]).remove();
            $("#lstRight").append(opt);
        }
    });

    $("#lstRight").bind("dblclick", function () {
        var options = $("#lstRight option:selected");
        for (var i = 0; i < options.length; i++) {
            var opt = $(options[i]).clone();
            $(options[i]).remove();
            $("#lstLeft").append(opt);
        }
    });
    //Arama
    $('#box').keyup(function () {
        var valThis = $("#box").val().toLowerCase();
        $('#lstLeft>option').each(function () {
            var text = $(this).text().toLowerCase();
            (text.indexOf(valThis) >= 0) ? $(this).show() : $(this).hide();
        });
    });
    //Arama
});