{
  ___.loadModule({
      'instantiate': function (___, IMPORTS___) {
        var $v = ___.readImport(IMPORTS___, '$v', {
            'getOuters': { '()': {} },
            'initOuter': { '()': {} },
            's': { '()': {} },
            'ro': { '()': {} },
            'dis': { '()': {} },
            'cm': { '()': {} },
            'r': { '()': {} }
          });
        var load = ___.readImport(IMPORTS___, 'load');
        var moduleResult___, $dis;
        moduleResult___ = ___.NO_RESULT;
        $dis = $v.getOuters();
        $v.initOuter('onerror');
        $v.s($v.ro('exports'), 'isNegative', ___.markFuncFreeze(function () {
              var isNegative$_meth;
              function isNegative$_meth$($dis, a) {
                if (a < 0) { return true; } else { return false; }
              }
              isNegative$_meth$.FUNC___ = 'isNegative$_meth$';
              isNegative$_meth = $v.dis(___.primFreeze(isNegative$_meth$),
                'isNegative$_meth');
              return isNegative$_meth;
            }).CALL___());
        moduleResult___ = $v.s($v.ro('exports'), 'isNonNegative',
          ___.markFuncFreeze(function () {
              var isNonNegative$_meth;
              function isNonNegative$_meth$($dis, a) {
                var m, r;
                m = $v.cm($v.ro('require'), 'async', [ load.async_canCall___?
                    load.async('./commonJsRecursion'): ___.callPub(load,
                      'async', [ './commonJsRecursion' ]) ]);
                r = $v.cm($v.r($v.ro('env'), 'Q'), 'defer', [ ]);
                $v.cm($v.r($v.ro('env'), 'Q'), 'when', [ m,
                    $v.dis(___.markFuncFreeze(function ($dis, module) {
                          $v.cm(r, 'resolve', [ !$v.cm(module, 'isNegative', [
                                  a ]) ]);
                        })), $v.dis(___.markFuncFreeze(function ($dis, reason)
                        {
                          $v.cm(r, 'resolve', [ $v.cm($v.r($v.ro('env'), 'Q'),
                                'reject', [ reason ]) ]);
                        })) ]);
                return $v.r(r, 'promise');
              }
              isNonNegative$_meth$.FUNC___ = 'isNonNegative$_meth$';
              isNonNegative$_meth = $v.dis(___.primFreeze(isNonNegative$_meth$)
                , 'isNonNegative$_meth');
              return isNonNegative$_meth;
            }).CALL___());
        return moduleResult___;
      },
      'cajolerName': 'com.google.caja',
      'cajolerVersion': '4251',
      'cajoledDate': 1282629652044
    });
}