$(function() {
    $("form#search").on("submit", function() {
        alert($("input[name=search]").val());
        $.ajax({
            url:"/citycouncil/agendas/_search",
            data: {
                term: {
                    text: "mayor"
                }
            },
            type: 'json'
        });
        return false;
    });

});
