{
  ___.loadModule({
      'instantiate': function (___, IMPORTS___) {
        var Q = ___.readImport(IMPORTS___, 'Q');
        var load = ___.readImport(IMPORTS___, 'load');
        var x = ___.readImport(IMPORTS___, 'x');
        var moduleResult___, result, x0___, m, x1___;
        moduleResult___ = ___.NO_RESULT;
        result = Q.defer_canCall___? Q.defer(): ___.callPub(Q, 'defer', [ ]);
        if (x <= 0) {
          x0___ = -1, result.resolve_canCall___? result.resolve(x0___):
          ___.callPub(result, 'resolve', [ x0___ ]);
        } else if (x == 1) {
          result.resolve_canCall___? result.resolve(1): ___.callPub(result,
            'resolve', [ 1 ]);
        } else {
          m = load.async_canCall___? load.async('./recursion'):
          ___.callPub(load, 'async', [ './recursion' ]);
          x1___ = ___.markFuncFreeze(function (module) {
              var r, x0___;
              r = module.CALL___(___.iM([ 'x', x - 1, 'load', load, 'Q', Q ]));
              x0___ = ___.markFuncFreeze(function (r) {
                  var x0___;
                  x0___ = x * r, result.resolve_canCall___?
                    result.resolve(x0___): ___.callPub(result, 'resolve', [
                      x0___ ]);
                }), Q.when_canCall___? Q.when(r, x0___): ___.callPub(Q, 'when',
                [ r, x0___ ]);
            }), Q.when_canCall___? Q.when(m, x1___): ___.callPub(Q, 'when', [
              m, x1___ ]);
        }
        moduleResult___ = result.promise_canRead___? result.promise:
        ___.readPub(result, 'promise');
        return moduleResult___;
      },
      'cajolerName': 'com.google.caja',
      'cajolerVersion': '4251',
      'cajoledDate': 1282629651787
    });
}