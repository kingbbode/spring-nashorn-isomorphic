'use strict';
module.exports = function(grunt) {
    grunt.initConfig({
        'handlebars': {
            options: {
                namespace: "Handlebars.templates",
                processName: function (filePath) {
                    var pattern = /templates\/(.+\/)*(.+)\.hbs/gi;
                    return pattern.exec(filePath)[2];
                }
            },
            compile: {
                files: {
                    "src/main/resources/static/js/templates.js": ["src/main/resources/templates/*.hbs","src/main/resources/templates/modules/*.hbs"]
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-handlebars');
    grunt.registerTask('default', ['handlebars']);
}
