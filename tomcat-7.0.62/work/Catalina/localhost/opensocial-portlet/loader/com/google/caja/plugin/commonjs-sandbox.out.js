{
  ___.loadModule({
      'instantiate': function (___, IMPORTS___) {
        var Error = ___.readImport(IMPORTS___, 'Error', {});
        var cajita = ___.readImport(IMPORTS___, 'cajita', {
            'newTable': { '()': {} },
            'freeze': { '()': {} }
          });
        var env = ___.readImport(IMPORTS___, 'env');
        var loader = ___.readImport(IMPORTS___, 'loader');
        var newMid = ___.readImport(IMPORTS___, 'newMid');
        var src = ___.readImport(IMPORTS___, 'src');
        var undefined = ___.readImport(IMPORTS___, 'undefined', {});
        var valijaModule = ___.readImport(IMPORTS___, 'valijaModule');
        var moduleResult___, commonJsSandboxMaker;
        moduleResult___ = ___.NO_RESULT;
        commonJsSandboxMaker = (function () {
            function commonJsSandboxMaker$_var(env, valijaMaker) {
              var exportsTable;
              function requireMaker(mid) {
                function theRequire(securedModule) {
                  var theExports, x0___, require, exports, valijaOuters,
                  cajitaImports;
                  theExports = (x0___ = securedModule.moduleURL_canRead___?
                    securedModule.moduleURL: ___.readPub(securedModule,
                      'moduleURL'), exportsTable.get_canCall___?
                    exportsTable.get(x0___): ___.callPub(exportsTable, 'get', [
                        x0___ ]));
                  if (theExports !== void 0) { return theExports; } else {
                    require =
                      requireMaker.CALL___(securedModule.moduleURL_canRead___?
                      securedModule.moduleURL: ___.readPub(securedModule,
                        'moduleURL'));
                    exports = ___.iM([ ]);
                    exportsTable.set_canCall___? exportsTable.set(newMid,
                      exports): ___.callPub(exportsTable, 'set', [ newMid,
                        exports ]);
                    valijaOuters = ___.iM([ 'env', env, 'require', require,
                        'exports', exports ]);
                    cajitaImports = cajita.freeze(___.iM([ '$v',
                          valijaMaker.CALL___(valijaOuters) ]));
                    securedModule.CALL___(cajitaImports);
                    return exports;
                  }
                }
                theRequire.FUNC___ = 'theRequire';
                function async(m) {
                  var Q, r, x0___, x1___;
                  Q = env.Q_canRead___? env.Q: ___.readPub(env, 'Q');
                  r = Q.defer_canCall___? Q.defer(): ___.callPub(Q, 'defer', [
                    ]);
                  x0___ = ___.markFuncFreeze(function (module) {
                      var theExports, x0___, require, exports, x1___,
                      valijaOuters, cajitaImports;
                      theExports = (x0___ = module.moduleURL_canRead___?
                        module.moduleURL: ___.readPub(module, 'moduleURL'),
                        exportsTable.get_canCall___? exportsTable.get(x0___):
                        ___.callPub(exportsTable, 'get', [ x0___ ]));
                      if (theExports !== void 0) {
                        r.resolve_canCall___? r.resolve(theExports):
                        ___.callPub(r, 'resolve', [ theExports ]);
                      } else {
                        require =
                          requireMaker.CALL___(module.moduleURL_canRead___?
                          module.moduleURL: ___.readPub(module, 'moduleURL'));
                        exports = ___.iM([ ]);
                        x1___ = module.moduleURL_canRead___? module.moduleURL:
                        ___.readPub(module, 'moduleURL'),
                        exportsTable.set_canCall___? exportsTable.set(x1___,
                          exports): ___.callPub(exportsTable, 'set', [ x1___,
                            exports ]);
                        valijaOuters = ___.iM([ 'env', env, 'require', require,
                            'exports', exports ]);
                        cajitaImports = cajita.freeze(___.iM([ '$v',
                              valijaMaker.CALL___(valijaOuters) ]));
                        module.CALL___(cajitaImports);
                        r.resolve_canCall___? r.resolve(exports):
                        ___.callPub(r, 'resolve', [ exports ]);
                      }
                    }), x1___ = ___.markFuncFreeze(function (reason) {
                      var x0___, x1___;
                      x1___ = (x0___ = 'Loading module ' + src + ' failed, ' +
                        reason, Q.reject_canCall___? Q.reject(x0___):
                        ___.callPub(Q, 'reject', [ x0___ ])),
                      r.resolve_canCall___? r.resolve(x1___): ___.callPub(r,
                        'resolve', [ x1___ ]);
                    }), Q.when_canCall___? Q.when(m, x0___, x1___):
                  ___.callPub(Q, 'when', [ m, x0___, x1___ ]);
                  return r.promise_canRead___? r.promise: ___.readPub(r,
                    'promise');
                }
                async.FUNC___ = 'async';
                ___.setStatic(theRequire, 'async', ___.primFreeze(async));
                ___.setStatic(theRequire, 'moduleURL', mid);
                return cajita.freeze(___.primFreeze(theRequire));
              }
              requireMaker.FUNC___ = 'requireMaker';
              function loadModule(securedModulePromise) {
                var x0___;
                return x0___ = requireMaker.CALL___(''),
                x0___.async_canCall___? x0___.async(securedModulePromise):
                ___.callPub(x0___, 'async', [ securedModulePromise ]);
              }
              loadModule.FUNC___ = 'loadModule';
              if ((env.Q_canRead___? env.Q: ___.readPub(env, 'Q')) ===
                undefined) {
                throw ___.construct(Error, [
                    'Include Q in env for serverJS sandbox modules.' ]);
              }
              exportsTable = cajita.newTable();
              return cajita.freeze(___.iM([ 'loadModule',
                    ___.primFreeze(loadModule) ]));
            }
            return ___.markFuncFreeze(commonJsSandboxMaker$_var,
              'commonJsSandboxMaker$_var');
          })();
        if (___.typeOf(loader) !== 'undefined') {
          loader.provide_canCall___? loader.provide(commonJsSandboxMaker):
          ___.callPub(loader, 'provide', [ commonJsSandboxMaker ]);
        }
        if (___.typeOf(env) !== 'undefined' && ___.typeOf(valijaModule) !==
          'undefined') {
          moduleResult___ = commonJsSandboxMaker.CALL___(env,
            ___.markFuncFreeze(function (valijaOuters) {
                return valijaModule.CALL___(___.iM([ 'outers', valijaOuters ]))
                  ;
              }));
        }
        return moduleResult___;
      },
      'cajolerName': 'com.google.caja',
      'cajolerVersion': '4251',
      'cajoledDate': 1282629611909
    });
}