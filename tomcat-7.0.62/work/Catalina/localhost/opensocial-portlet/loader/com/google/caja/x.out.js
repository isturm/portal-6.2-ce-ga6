{
  ___.loadModule({
      'instantiate': function (___, IMPORTS___) {
        var $v = ___.readImport(IMPORTS___, '$v', {
            'getOuters': { '()': {} },
            'initOuter': { '()': {} },
            'so': { '()': {} }
          });
        var moduleResult___, $dis;
        moduleResult___ = ___.NO_RESULT;
        $dis = $v.getOuters();
        $v.initOuter('onerror');
        moduleResult___ = $v.so('x', 3);
        return moduleResult___;
      },
      'cajolerName': 'com.google.caja',
      'cajolerVersion': '4251',
      'cajoledDate': 1282629651826
    });
}