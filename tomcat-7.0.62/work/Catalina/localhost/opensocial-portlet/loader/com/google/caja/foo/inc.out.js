{
  ___.loadModule({
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
        var load = ___.readImport(IMPORTS___, 'load');
        var moduleResult___, $dis;
        moduleResult___ = ___.NO_RESULT;
        $dis = $v.getOuters();
        $v.initOuter('onerror');
        $v.cm($v.ro('env'), 'assertEquals', [ $v.r($v.ro('env'), 'x'), 6 ]);
        moduleResult___ = $v.s($v.ro('exports'), 'inc',
          ___.markFuncFreeze(function () {
              var inc$_meth;
              function inc$_meth$($dis, x) {
                var r, m;
                r = $v.cm($v.r($v.ro('env'), 'Q'), 'defer', [ ]);
                m = $v.cm($v.ro('require'), 'async', [ load.async_canCall___?
                    load.async('../add'): ___.callPub(load, 'async', [ '../add'
                      ]) ]);
                $v.cm($v.r($v.ro('env'), 'Q'), 'when', [ m,
                    $v.dis(___.markFuncFreeze(function ($dis, module) {
                          $v.cm(r, 'resolve', [ $v.cm(module, 'add', [ x, 1 ])
                            ]);
                        })), $v.dis(___.markFuncFreeze(function ($dis, reason)
                        {
                          $v.cm(r, 'resolve', [ $v.cm($v.r($v.ro('env'), 'Q'),
                                'reject', [ 'Loading module Add failed, ' +
                                  reason ]) ]);
                        })) ]);
                return $v.r(r, 'promise');
              }
              inc$_meth$.FUNC___ = 'inc$_meth$';
              inc$_meth = $v.dis(___.primFreeze(inc$_meth$), 'inc$_meth');
              return inc$_meth;
            }).CALL___());
        return moduleResult___;
      },
      'cajolerName': 'com.google.caja',
      'cajolerVersion': '4251',
      'cajoledDate': 1282629651875
    });
}