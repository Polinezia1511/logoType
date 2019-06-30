$(function(){ /* DOM ready */
    $("#selectType").change(function() {
        var value =  $(this).val();
        if (value==="SINGLE_LINE" ||
            value==="MULTI_LINE" ||
            value==="DATE") {
            $("#optionsField").hide();
        } else {
            $("#optionsField").show();
        }
    });
});