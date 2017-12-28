karma-ember-precompile-brunch
=============================

Usage
===

```javascript
    .......

    // Include to plugins list
    plugins: [
      'karma-ember-precompile-brunch'
    ],

    // Create configuration
    emberPrecompileBrunchPreprocessor: {
      jqueryPath: 'path/to/jquery.js',
      handlebarsPath: 'path/to/handlebars.js'
      emberPath: 'path/to/ember.js',
    },

    // Use it! :)
    preprocessors: {
      '**/*.hbs': 'ember-precompile-brunch'
    }
```