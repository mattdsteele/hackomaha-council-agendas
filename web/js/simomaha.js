$(function() {
    var t = {};

    t.searchItem = _.template($("#listItemTemplate").html());

    t.populateItems = function(data) {
        var h, hit;
        for ( h in data.hits.hits ) {
            hit = data.hits.hits[h];
            $("#results").append(t.searchItem({
                id: hit._id,
                title: hit._id,
                items: hit.fields.items
            }));
            $("#progress").fadeOut();
        }
    };

    $("#progress").hide();
    $("form#search").on("submit", function() {
        $("#progress").fadeIn();
        $.ajax({
            url:"/citycouncil/agendas/_search?fields=items",
            data: JSON.stringify({
                query: {
                    term: {
                        text: $("input[name=search]").val()
                    }
                }
            }),
            type: 'json',
            success: function(data) {
                t.populateItems(data);
            }
        });
        return false;
    });

});
