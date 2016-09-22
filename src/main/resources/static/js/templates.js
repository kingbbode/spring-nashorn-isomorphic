this["Handlebars"] = this["Handlebars"] || {};
this["Handlebars"]["templates"] = this["Handlebars"]["templates"] || {};

this["Handlebars"]["templates"]["index"] = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function";

  return "<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n    <meta charset=\"utf-8\" />\r\n    <title>Spring Nashorn isomorphic handlebars</title>\r\n    <meta name=\"description\" content=\"overview &amp; stats\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\r\n</head>\r\n<body>\r\n<div>\r\n    <p>Layout Text : "
    + container.escapeExpression(((helper = (helper = helpers.text || (depth0 != null ? depth0.text : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"text","hash":{},"data":data}) : helper)))
    + "</p>\r\n</div>\r\n<div id=\"layer\">\r\n    "
    + ((stack1 = ((helper = (helper = helpers.layer || (depth0 != null ? depth0.layer : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"layer","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "\r\n</div>\r\n<a href=\"javascript:;\" id = \"call\">client call</a>\r\n<script src=\"/webjars/jquery/3.1.0/jquery.min.js\"></script>\r\n<script src=\"/webjars/handlebars/4.0.5/handlebars.min.js\"></script>\r\n<script src=\"/js/templates.js\"></script>\r\n<script>\r\n    var $layer = $('#layer');\r\n    $('#call').click(function() {\r\n        $.ajax({\r\n            'url': '/rest',\r\n            'type': 'GET',\r\n            'dataType': 'json',\r\n            'success': function (data) {\r\n                $layer.html(Handlebars.templates['layer'](data));\r\n            }\r\n        });\r\n    });\r\n</script>\r\n</body>\r\n</html>\r\n";
},"useData":true});

this["Handlebars"]["templates"]["layer"] = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper;

  return "<p>Layer Text : "
    + container.escapeExpression(((helper = (helper = helpers.text || (depth0 != null ? depth0.text : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"text","hash":{},"data":data}) : helper)))
    + "</p>";
},"useData":true});