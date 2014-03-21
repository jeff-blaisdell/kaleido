// Generated on 2014-01-09 using generator-angular 0.7.1
'use strict';

// # Globbing
// for performance reasons we're only matching one level down:
// 'test/spec/{,*/}*.js'
// use this if you want to recursively match all subfolders:
// 'test/spec/**/*.js'

module.exports = function (grunt) {

	// Load grunt tasks automatically
	require('load-grunt-tasks')(grunt);

	// Time how long tasks take. Can help when optimizing build times
	require('time-grunt')(grunt);

	// Define the configuration for all the tasks
	grunt.initConfig({

		// Project settings
		yeoman: {
			// configurable paths
			app: require('./bower.json').appPath || 'app',
			dist: 'dist'
		},

		// Watches files for changes and runs tasks based on the changed files
		watch: {
            lessCss: {
                tasks: ['less:development'],
                files: ['<%= yeoman.app %>/theme/*.less', '<%= yeoman.app %>/less/*.less'],
            }
		},

		// Make sure code styles are up to par and there are no obvious mistakes
		jshint: {
			options: {
				jshintrc: '.jshintrc',
				reporter: require('jshint-stylish')
			},
			all: [
				'Gruntfile.js',
				'<%= yeoman.app %>/js/{,*/}*.js'
			],
			test: {
				options: {
					jshintrc: 'test/.jshintrc'
				},
				src: ['test/spec/{,*/}*.js']
			}
		},

		// Empties folders to start fresh
		clean: {
			dist: {
				files: [
					{
						dot: true,
						src: [
							'.tmp',
							'<%= yeoman.dist %>/*',
							'!<%= yeoman.dist %>/.git*'
						]
					}
				]
			},
			server: '.tmp'
		},

        less: {
            development: {
                options: {
                    yuicompress: false
                },
                files: [
                    {
                        expand: true,
                        flatten: true,
                        src: ['<%= yeoman.app %>/theme/*.less', '<%= yeoman.app %>/less/*.less'],
                        dest: '<%= yeoman.app %>/css/',
                        ext: '.css'
                    }
                ]
            },
            production: {
                options: {
                    yuicompress: true
                },
                files: [
                    {
                        expand: true,
                        flatten: true,
                        src: ['<%= yeoman.app %>/theme/*.less', '<%= yeoman.app %>/less/*.less'],
                        dest: '<%= yeoman.app %>/css/',
                        ext: '.css'
                    }
                ]
            }
        }
	});

	grunt.registerTask('test', [
		'karma'
	]);

	grunt.registerTask('build', [

	]);

	grunt.registerTask('default', [

	]);
};
