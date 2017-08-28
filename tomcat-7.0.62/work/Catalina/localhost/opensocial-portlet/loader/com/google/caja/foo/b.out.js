{
  ___.loadModule({
      'instantiate': function (___, IMPORTS___) {
        var Q = ___.readImport(IMPORTS___, 'Q');
        var fail = ___.readImport(IMPORTS___, 'fail');
        var load = ___.readImport(IMPORTS___, 'load');
        var x = ___.readImport(IMPORTS___, 'x');
        var y = ___.readImport(IMPORTS___, 'y');
        var moduleResult___, m, f1, f2;
        moduleResult___ = ___.NO_RESULT;
        m = load.async_canCall___? load.async('../c'): ___.callPub(load,
          'async', [ '../c' ]);
        f1 = (function () {
            function f1$_var(module) {
              var r1, r2;
              r1 = module.CALL___(___.iM([ 'x', x ]));
              r2 = module.CALL___(___.iM([ 'x', y ]));
              return r1 + r2;
            }
            return ___.markFuncFreeze(f1$_var, 'f1$_var');
          })();
        f2 = (function () {
            function f2$_var(reason) {
              fail.CALL___('Loading module C failed, ' + reason);
            }
            return ___.markFuncFreeze(f2$_var, 'f2$_var');
          })();
        moduleResult___ = Q.when_canCall___? Q.when(m, f1, f2): ___.callPub(Q,
          'when', [ m, f1, f2 ]);
        return moduleResult___;
      },
      'cajolerName': 'com.google.caja',
      'cajolerVersion': '4251',
      'cajoledDate': 1282629651745
    });
}