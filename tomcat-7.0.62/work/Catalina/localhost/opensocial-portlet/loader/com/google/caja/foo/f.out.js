{
  ___.loadModule({
      'instantiate': function (___, IMPORTS___) {
        var moduleMap___ = [ ___.prepareModule({
              'instantiate': function (___, IMPORTS___) {
                var x = ___.readImport(IMPORTS___, 'x');
                var moduleResult___;
                moduleResult___ = ___.NO_RESULT;
                moduleResult___ = x + 1;
                return moduleResult___;
              },
              'cajolerName': 'com.google.caja',
              'cajolerVersion': '4251',
              'cajoledDate': 1282629652121,
              'src':
              'file:/Users/jasvir/src/svn-changes/caja-codemirror/google-caja/tests/com/google/caja/c.js'
            }) ];
        return ___.prepareModule({
            'instantiate': function (___, IMPORTS___) {
              var load = ___.readImport(IMPORTS___, 'load');
              var x = ___.readImport(IMPORTS___, 'x');
              var y = ___.readImport(IMPORTS___, 'y');
              var moduleResult___, m;
              moduleResult___ = ___.NO_RESULT;
              m = moduleMap___[ 0 ];
              moduleResult___ = m.CALL___(___.iM([ 'x', x ])) +
                m.CALL___(___.iM([ 'x', y ]));
              return moduleResult___;
            },
            'inlinedModules': [ '../c' ],
            'cajolerName': 'com.google.caja',
            'cajolerVersion': '4251',
            'cajoledDate': 1282629652122
          })(IMPORTS___);
      },
      'cajolerName': 'com.google.caja',
      'cajolerVersion': '4251',
      'cajoledDate': 1282629652127
    });
}