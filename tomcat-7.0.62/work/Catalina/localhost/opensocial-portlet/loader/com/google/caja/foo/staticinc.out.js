{
  ___.loadModule({
      'instantiate': function (___, IMPORTS___) {
        var moduleMap___ = [ ___.prepareModule({
              'instantiate': function (___, IMPORTS___) {
                var $v = ___.readImport(IMPORTS___, '$v', {
                    'getOuters': { '()': {} },
                    'initOuter': { '()': {} },
                    'cm': { '()': {} },
                    'ro': { '()': {} },
                    'r': { '()': {} },
                    's': { '()': {} },
                    'dis': { '()': {} }
                  });
                var moduleResult___, $dis;
                moduleResult___ = ___.NO_RESULT;
                $dis = $v.getOuters();
                $v.initOuter('onerror');
                $v.cm($v.ro('env'), 'assertEquals', [ $v.r($v.ro('env'), 'w'),
                    6 ]);
                moduleResult___ = $v.s($v.ro('exports'), 'add',
                  ___.markFuncFreeze(function () {
                      var add$_meth;
                      function add$_meth$($dis, a, b) {
                        return a + b;
                      }
                      add$_meth$.FUNC___ = 'add$_meth$';
                      add$_meth = $v.dis(___.primFreeze(add$_meth$),
                        'add$_meth');
                      return add$_meth;
                    }).CALL___());
                return moduleResult___;
              },
              'cajolerName': 'com.google.caja',
              'cajolerVersion': '4251',
              'cajoledDate': 1282629652168,
              'src':
              'file:/Users/jasvir/src/svn-changes/caja-codemirror/google-caja/tests/com/google/caja/sum.js'
            }) ];
        return ___.prepareModule({
            'instantiate': function (___, IMPORTS___) {
              var $v = ___.readImport(IMPORTS___, '$v', {
                  'getOuters': { '()': {} },
                  'initOuter': { '()': {} },
                  'cm': { '()': {} },
                  'ro': { '()': {} },
                  'r': { '()': {} },
                  's': { '()': {} },
                  'cf': { '()': {} },
                  'dis': { '()': {} }
                });
              var load = ___.readImport(IMPORTS___, 'load');
              var moduleResult___, $dis;
              moduleResult___ = ___.NO_RESULT;
              $dis = $v.getOuters();
              $v.initOuter('onerror');
              $v.cm($v.ro('env'), 'assertEquals', [ $v.r($v.ro('env'), 'w'), 6
                ]);
              moduleResult___ = $v.s($v.ro('exports'), 'inc',
                ___.markFuncFreeze(function () {
                    var inc$_meth;
                    function inc$_meth$($dis, x) {
                      return $v.cm($v.cf($v.ro('require'), [ moduleMap___[ 0 ]
                          ]), 'add', [ x, 1 ]);
                    }
                    inc$_meth$.FUNC___ = 'inc$_meth$';
                    inc$_meth = $v.dis(___.primFreeze(inc$_meth$), 'inc$_meth')
                      ;
                    return inc$_meth;
                  }).CALL___());
              return moduleResult___;
            },
            'inlinedModules': [ '../sum' ],
            'cajolerName': 'com.google.caja',
            'cajolerVersion': '4251',
            'cajoledDate': 1282629652182
          })(IMPORTS___);
      },
      'cajolerName': 'com.google.caja',
      'cajolerVersion': '4251',
      'cajoledDate': 1282629652185
    });
}