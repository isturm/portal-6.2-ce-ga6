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
        var moduleResult___, $dis;
        moduleResult___ = ___.NO_RESULT;
        $dis = $v.getOuters();
        $v.initOuter('onerror');
        $v.cm($v.ro('env'), 'assertEquals', [ $v.r($v.ro('env'), 'x'), 6 ]);
        moduleResult___ = $v.s($v.ro('exports'), 'add',
          ___.markFuncFreeze(function () {
              var add$_meth;
              function add$_meth$($dis, a, b) {
                return a + b;
              }
              add$_meth$.FUNC___ = 'add$_meth$';
              add$_meth = $v.dis(___.primFreeze(add$_meth$), 'add$_meth');
              return add$_meth;
            }).CALL___());
        return moduleResult___;
      },
      'cajolerName': 'com.google.caja',
      'cajolerVersion': '4251',
      'cajoledDate': 1282629651902
    });
}