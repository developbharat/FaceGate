package com.developbharat.facegate.domain.data.database

import android.content.Context
import com.developbharat.facegate.domain.models.Person
import net.sqlcipher.database.SQLiteDatabase
import javax.inject.Inject
import kotlin.math.sqrt


class VectorsDatabase @Inject constructor(
    appContext: Context
) : IVectorsDatabase {
    private var database: SQLiteDatabase? = null


    suspend fun searchFaceInFacesTable(vectors: Iterable<Float>): Person? {
        val params = vectors.map { value -> value.toString() }.toTypedArray()
        val cursor = database!!.rawQuery(
            """
            SELECT id, uid, (
            (vec_val_1 - ?1) * (vec_val_1 - ?1)+
            (vec_val_2 - ?2) * (vec_val_2 - ?2)+
            (vec_val_3 - ?3) * (vec_val_3 - ?3)+
            (vec_val_4 - ?4) * (vec_val_4 - ?4)+
            (vec_val_5 - ?5) * (vec_val_5 - ?5)+
            (vec_val_6 - ?6) * (vec_val_6 - ?6)+
            (vec_val_7 - ?7) * (vec_val_7 - ?7)+
            (vec_val_8 - ?8) * (vec_val_8 - ?8)+
            (vec_val_9 - ?9) * (vec_val_9 - ?9)+
            (vec_val_10 - ?10) * (vec_val_10 - ?10)+
            (vec_val_11 - ?11) * (vec_val_11 - ?11)+
            (vec_val_12 - ?12) * (vec_val_12 - ?12)+
            (vec_val_13 - ?13) * (vec_val_13 - ?13)+
            (vec_val_14 - ?14) * (vec_val_14 - ?14)+
            (vec_val_15 - ?15) * (vec_val_15 - ?15)+
            (vec_val_16 - ?16) * (vec_val_16 - ?16)+
            (vec_val_17 - ?17) * (vec_val_17 - ?17)+
            (vec_val_18 - ?18) * (vec_val_18 - ?18)+
            (vec_val_19 - ?19) * (vec_val_19 - ?19)+
            (vec_val_20 - ?20) * (vec_val_20 - ?20)+
            (vec_val_21 - ?21) * (vec_val_21 - ?21)+
            (vec_val_22 - ?22) * (vec_val_22 - ?22)+
            (vec_val_23 - ?23) * (vec_val_23 - ?23)+
            (vec_val_24 - ?24) * (vec_val_24 - ?24)+
            (vec_val_25 - ?25) * (vec_val_25 - ?25)+
            (vec_val_26 - ?26) * (vec_val_26 - ?26)+
            (vec_val_27 - ?27) * (vec_val_27 - ?27)+
            (vec_val_28 - ?28) * (vec_val_28 - ?28)+
            (vec_val_29 - ?29) * (vec_val_29 - ?29)+
            (vec_val_30 - ?30) * (vec_val_30 - ?30)+
            (vec_val_31 - ?31) * (vec_val_31 - ?31)+
            (vec_val_32 - ?32) * (vec_val_32 - ?32)+
            (vec_val_33 - ?33) * (vec_val_33 - ?33)+
            (vec_val_34 - ?34) * (vec_val_34 - ?34)+
            (vec_val_35 - ?35) * (vec_val_35 - ?35)+
            (vec_val_36 - ?36) * (vec_val_36 - ?36)+
            (vec_val_37 - ?37) * (vec_val_37 - ?37)+
            (vec_val_38 - ?38) * (vec_val_38 - ?38)+
            (vec_val_39 - ?39) * (vec_val_39 - ?39)+
            (vec_val_40 - ?40) * (vec_val_40 - ?40)+
            (vec_val_41 - ?41) * (vec_val_41 - ?41)+
            (vec_val_42 - ?42) * (vec_val_42 - ?42)+
            (vec_val_43 - ?43) * (vec_val_43 - ?43)+
            (vec_val_44 - ?44) * (vec_val_44 - ?44)+
            (vec_val_45 - ?45) * (vec_val_45 - ?45)+
            (vec_val_46 - ?46) * (vec_val_46 - ?46)+
            (vec_val_47 - ?47) * (vec_val_47 - ?47)+
            (vec_val_48 - ?48) * (vec_val_48 - ?48)+
            (vec_val_49 - ?49) * (vec_val_49 - ?49)+
            (vec_val_50 - ?50) * (vec_val_50 - ?50)+
            (vec_val_51 - ?51) * (vec_val_51 - ?51)+
            (vec_val_52 - ?52) * (vec_val_52 - ?52)+
            (vec_val_53 - ?53) * (vec_val_53 - ?53)+
            (vec_val_54 - ?54) * (vec_val_54 - ?54)+
            (vec_val_55 - ?55) * (vec_val_55 - ?55)+
            (vec_val_56 - ?56) * (vec_val_56 - ?56)+
            (vec_val_57 - ?57) * (vec_val_57 - ?57)+
            (vec_val_58 - ?58) * (vec_val_58 - ?58)+
            (vec_val_59 - ?59) * (vec_val_59 - ?59)+
            (vec_val_60 - ?60) * (vec_val_60 - ?60)+
            (vec_val_61 - ?61) * (vec_val_61 - ?61)+
            (vec_val_62 - ?62) * (vec_val_62 - ?62)+
            (vec_val_63 - ?63) * (vec_val_63 - ?63)+
            (vec_val_64 - ?64) * (vec_val_64 - ?64)+
            (vec_val_65 - ?65) * (vec_val_65 - ?65)+
            (vec_val_66 - ?66) * (vec_val_66 - ?66)+
            (vec_val_67 - ?67) * (vec_val_67 - ?67)+
            (vec_val_68 - ?68) * (vec_val_68 - ?68)+
            (vec_val_69 - ?69) * (vec_val_69 - ?69)+
            (vec_val_70 - ?70) * (vec_val_70 - ?70)+
            (vec_val_71 - ?71) * (vec_val_71 - ?71)+
            (vec_val_72 - ?72) * (vec_val_72 - ?72)+
            (vec_val_73 - ?73) * (vec_val_73 - ?73)+
            (vec_val_74 - ?74) * (vec_val_74 - ?74)+
            (vec_val_75 - ?75) * (vec_val_75 - ?75)+
            (vec_val_76 - ?76) * (vec_val_76 - ?76)+
            (vec_val_77 - ?77) * (vec_val_77 - ?77)+
            (vec_val_78 - ?78) * (vec_val_78 - ?78)+
            (vec_val_79 - ?79) * (vec_val_79 - ?79)+
            (vec_val_80 - ?80) * (vec_val_80 - ?80)+
            (vec_val_81 - ?81) * (vec_val_81 - ?81)+
            (vec_val_82 - ?82) * (vec_val_82 - ?82)+
            (vec_val_83 - ?83) * (vec_val_83 - ?83)+
            (vec_val_84 - ?84) * (vec_val_84 - ?84)+
            (vec_val_85 - ?85) * (vec_val_85 - ?85)+
            (vec_val_86 - ?86) * (vec_val_86 - ?86)+
            (vec_val_87 - ?87) * (vec_val_87 - ?87)+
            (vec_val_88 - ?88) * (vec_val_88 - ?88)+
            (vec_val_89 - ?89) * (vec_val_89 - ?89)+
            (vec_val_90 - ?90) * (vec_val_90 - ?90)+
            (vec_val_91 - ?91) * (vec_val_91 - ?91)+
            (vec_val_92 - ?92) * (vec_val_92 - ?92)+
            (vec_val_93 - ?93) * (vec_val_93 - ?93)+
            (vec_val_94 - ?94) * (vec_val_94 - ?94)+
            (vec_val_95 - ?95) * (vec_val_95 - ?95)+
            (vec_val_96 - ?96) * (vec_val_96 - ?96)+
            (vec_val_97 - ?97) * (vec_val_97 - ?97)+
            (vec_val_98 - ?98) * (vec_val_98 - ?98)+
            (vec_val_99 - ?99) * (vec_val_99 - ?99)+
            (vec_val_100 - ?100) * (vec_val_100 - ?100)+
            (vec_val_101 - ?101) * (vec_val_101 - ?101)+
            (vec_val_102 - ?102) * (vec_val_102 - ?102)+
            (vec_val_103 - ?103) * (vec_val_103 - ?103)+
            (vec_val_104 - ?104) * (vec_val_104 - ?104)+
            (vec_val_105 - ?105) * (vec_val_105 - ?105)+
            (vec_val_106 - ?106) * (vec_val_106 - ?106)+
            (vec_val_107 - ?107) * (vec_val_107 - ?107)+
            (vec_val_108 - ?108) * (vec_val_108 - ?108)+
            (vec_val_109 - ?109) * (vec_val_109 - ?109)+
            (vec_val_110 - ?110) * (vec_val_110 - ?110)+
            (vec_val_111 - ?111) * (vec_val_111 - ?111)+
            (vec_val_112 - ?112) * (vec_val_112 - ?112)+
            (vec_val_113 - ?113) * (vec_val_113 - ?113)+
            (vec_val_114 - ?114) * (vec_val_114 - ?114)+
            (vec_val_115 - ?115) * (vec_val_115 - ?115)+
            (vec_val_116 - ?116) * (vec_val_116 - ?116)+
            (vec_val_117 - ?117) * (vec_val_117 - ?117)+
            (vec_val_118 - ?118) * (vec_val_118 - ?118)+
            (vec_val_119 - ?119) * (vec_val_119 - ?119)+
            (vec_val_120 - ?120) * (vec_val_120 - ?120)+
            (vec_val_121 - ?121) * (vec_val_121 - ?121)+
            (vec_val_122 - ?122) * (vec_val_122 - ?122)+
            (vec_val_123 - ?123) * (vec_val_123 - ?123)+
            (vec_val_124 - ?124) * (vec_val_124 - ?124)+
            (vec_val_125 - ?125) * (vec_val_125 - ?125)+
            (vec_val_126 - ?126) * (vec_val_126 - ?126)+
            (vec_val_127 - ?127) * (vec_val_127 - ?127)+
            (vec_val_128 - ?128) * (vec_val_128 - ?128)+
            (vec_val_129 - ?129) * (vec_val_129 - ?129)+
            (vec_val_130 - ?130) * (vec_val_130 - ?130)+
            (vec_val_131 - ?131) * (vec_val_131 - ?131)+
            (vec_val_132 - ?132) * (vec_val_132 - ?132)+
            (vec_val_133 - ?133) * (vec_val_133 - ?133)+
            (vec_val_134 - ?134) * (vec_val_134 - ?134)+
            (vec_val_135 - ?135) * (vec_val_135 - ?135)+
            (vec_val_136 - ?136) * (vec_val_136 - ?136)+
            (vec_val_137 - ?137) * (vec_val_137 - ?137)+
            (vec_val_138 - ?138) * (vec_val_138 - ?138)+
            (vec_val_139 - ?139) * (vec_val_139 - ?139)+
            (vec_val_140 - ?140) * (vec_val_140 - ?140)+
            (vec_val_141 - ?141) * (vec_val_141 - ?141)+
            (vec_val_142 - ?142) * (vec_val_142 - ?142)+
            (vec_val_143 - ?143) * (vec_val_143 - ?143)+
            (vec_val_144 - ?144) * (vec_val_144 - ?144)+
            (vec_val_145 - ?145) * (vec_val_145 - ?145)+
            (vec_val_146 - ?146) * (vec_val_146 - ?146)+
            (vec_val_147 - ?147) * (vec_val_147 - ?147)+
            (vec_val_148 - ?148) * (vec_val_148 - ?148)+
            (vec_val_149 - ?149) * (vec_val_149 - ?149)+
            (vec_val_150 - ?150) * (vec_val_150 - ?150)+
            (vec_val_151 - ?151) * (vec_val_151 - ?151)+
            (vec_val_152 - ?152) * (vec_val_152 - ?152)+
            (vec_val_153 - ?153) * (vec_val_153 - ?153)+
            (vec_val_154 - ?154) * (vec_val_154 - ?154)+
            (vec_val_155 - ?155) * (vec_val_155 - ?155)+
            (vec_val_156 - ?156) * (vec_val_156 - ?156)+
            (vec_val_157 - ?157) * (vec_val_157 - ?157)+
            (vec_val_158 - ?158) * (vec_val_158 - ?158)+
            (vec_val_159 - ?159) * (vec_val_159 - ?159)+
            (vec_val_160 - ?160) * (vec_val_160 - ?160)+
            (vec_val_161 - ?161) * (vec_val_161 - ?161)+
            (vec_val_162 - ?162) * (vec_val_162 - ?162)+
            (vec_val_163 - ?163) * (vec_val_163 - ?163)+
            (vec_val_164 - ?164) * (vec_val_164 - ?164)+
            (vec_val_165 - ?165) * (vec_val_165 - ?165)+
            (vec_val_166 - ?166) * (vec_val_166 - ?166)+
            (vec_val_167 - ?167) * (vec_val_167 - ?167)+
            (vec_val_168 - ?168) * (vec_val_168 - ?168)+
            (vec_val_169 - ?169) * (vec_val_169 - ?169)+
            (vec_val_170 - ?170) * (vec_val_170 - ?170)+
            (vec_val_171 - ?171) * (vec_val_171 - ?171)+
            (vec_val_172 - ?172) * (vec_val_172 - ?172)+
            (vec_val_173 - ?173) * (vec_val_173 - ?173)+
            (vec_val_174 - ?174) * (vec_val_174 - ?174)+
            (vec_val_175 - ?175) * (vec_val_175 - ?175)+
            (vec_val_176 - ?176) * (vec_val_176 - ?176)+
            (vec_val_177 - ?177) * (vec_val_177 - ?177)+
            (vec_val_178 - ?178) * (vec_val_178 - ?178)+
            (vec_val_179 - ?179) * (vec_val_179 - ?179)+
            (vec_val_180 - ?180) * (vec_val_180 - ?180)+
            (vec_val_181 - ?181) * (vec_val_181 - ?181)+
            (vec_val_182 - ?182) * (vec_val_182 - ?182)+
            (vec_val_183 - ?183) * (vec_val_183 - ?183)+
            (vec_val_184 - ?184) * (vec_val_184 - ?184)+
            (vec_val_185 - ?185) * (vec_val_185 - ?185)+
            (vec_val_186 - ?186) * (vec_val_186 - ?186)+
            (vec_val_187 - ?187) * (vec_val_187 - ?187)+
            (vec_val_188 - ?188) * (vec_val_188 - ?188)+
            (vec_val_189 - ?189) * (vec_val_189 - ?189)+
            (vec_val_190 - ?190) * (vec_val_190 - ?190)+
            (vec_val_191 - ?191) * (vec_val_191 - ?191)+
            (vec_val_192 - ?192) * (vec_val_192 - ?192)+
            (vec_val_193 - ?193) * (vec_val_193 - ?193)+
            (vec_val_194 - ?194) * (vec_val_194 - ?194)+
            (vec_val_195 - ?195) * (vec_val_195 - ?195)+
            (vec_val_196 - ?196) * (vec_val_196 - ?196)+
            (vec_val_197 - ?197) * (vec_val_197 - ?197)+
            (vec_val_198 - ?198) * (vec_val_198 - ?198)+
            (vec_val_199 - ?199) * (vec_val_199 - ?199)+
            (vec_val_200 - ?200) * (vec_val_200 - ?200)+
            (vec_val_201 - ?201) * (vec_val_201 - ?201)+
            (vec_val_202 - ?202) * (vec_val_202 - ?202)+
            (vec_val_203 - ?203) * (vec_val_203 - ?203)+
            (vec_val_204 - ?204) * (vec_val_204 - ?204)+
            (vec_val_205 - ?205) * (vec_val_205 - ?205)+
            (vec_val_206 - ?206) * (vec_val_206 - ?206)+
            (vec_val_207 - ?207) * (vec_val_207 - ?207)+
            (vec_val_208 - ?208) * (vec_val_208 - ?208)+
            (vec_val_209 - ?209) * (vec_val_209 - ?209)+
            (vec_val_210 - ?210) * (vec_val_210 - ?210)+
            (vec_val_211 - ?211) * (vec_val_211 - ?211)+
            (vec_val_212 - ?212) * (vec_val_212 - ?212)+
            (vec_val_213 - ?213) * (vec_val_213 - ?213)+
            (vec_val_214 - ?214) * (vec_val_214 - ?214)+
            (vec_val_215 - ?215) * (vec_val_215 - ?215)+
            (vec_val_216 - ?216) * (vec_val_216 - ?216)+
            (vec_val_217 - ?217) * (vec_val_217 - ?217)+
            (vec_val_218 - ?218) * (vec_val_218 - ?218)+
            (vec_val_219 - ?219) * (vec_val_219 - ?219)+
            (vec_val_220 - ?220) * (vec_val_220 - ?220)+
            (vec_val_221 - ?221) * (vec_val_221 - ?221)+
            (vec_val_222 - ?222) * (vec_val_222 - ?222)+
            (vec_val_223 - ?223) * (vec_val_223 - ?223)+
            (vec_val_224 - ?224) * (vec_val_224 - ?224)+
            (vec_val_225 - ?225) * (vec_val_225 - ?225)+
            (vec_val_226 - ?226) * (vec_val_226 - ?226)+
            (vec_val_227 - ?227) * (vec_val_227 - ?227)+
            (vec_val_228 - ?228) * (vec_val_228 - ?228)+
            (vec_val_229 - ?229) * (vec_val_229 - ?229)+
            (vec_val_230 - ?230) * (vec_val_230 - ?230)+
            (vec_val_231 - ?231) * (vec_val_231 - ?231)+
            (vec_val_232 - ?232) * (vec_val_232 - ?232)+
            (vec_val_233 - ?233) * (vec_val_233 - ?233)+
            (vec_val_234 - ?234) * (vec_val_234 - ?234)+
            (vec_val_235 - ?235) * (vec_val_235 - ?235)+
            (vec_val_236 - ?236) * (vec_val_236 - ?236)+
            (vec_val_237 - ?237) * (vec_val_237 - ?237)+
            (vec_val_238 - ?238) * (vec_val_238 - ?238)+
            (vec_val_239 - ?239) * (vec_val_239 - ?239)+
            (vec_val_240 - ?240) * (vec_val_240 - ?240)+
            (vec_val_241 - ?241) * (vec_val_241 - ?241)+
            (vec_val_242 - ?242) * (vec_val_242 - ?242)+
            (vec_val_243 - ?243) * (vec_val_243 - ?243)+
            (vec_val_244 - ?244) * (vec_val_244 - ?244)+
            (vec_val_245 - ?245) * (vec_val_245 - ?245)+
            (vec_val_246 - ?246) * (vec_val_246 - ?246)+
            (vec_val_247 - ?247) * (vec_val_247 - ?247)+
            (vec_val_248 - ?248) * (vec_val_248 - ?248)+
            (vec_val_249 - ?249) * (vec_val_249 - ?249)+
            (vec_val_250 - ?250) * (vec_val_250 - ?250)+
            (vec_val_251 - ?251) * (vec_val_251 - ?251)+
            (vec_val_252 - ?252) * (vec_val_252 - ?252)+
            (vec_val_253 - ?253) * (vec_val_253 - ?253)+
            (vec_val_254 - ?254) * (vec_val_254 - ?254)+
            (vec_val_255 - ?255) * (vec_val_255 - ?255)+
            (vec_val_256 - ?256) * (vec_val_256 - ?256)+
            (vec_val_257 - ?257) * (vec_val_257 - ?257)+
            (vec_val_258 - ?258) * (vec_val_258 - ?258)+
            (vec_val_259 - ?259) * (vec_val_259 - ?259)+
            (vec_val_260 - ?260) * (vec_val_260 - ?260)+
            (vec_val_261 - ?261) * (vec_val_261 - ?261)+
            (vec_val_262 - ?262) * (vec_val_262 - ?262)+
            (vec_val_263 - ?263) * (vec_val_263 - ?263)+
            (vec_val_264 - ?264) * (vec_val_264 - ?264)+
            (vec_val_265 - ?265) * (vec_val_265 - ?265)+
            (vec_val_266 - ?266) * (vec_val_266 - ?266)+
            (vec_val_267 - ?267) * (vec_val_267 - ?267)+
            (vec_val_268 - ?268) * (vec_val_268 - ?268)+
            (vec_val_269 - ?269) * (vec_val_269 - ?269)+
            (vec_val_270 - ?270) * (vec_val_270 - ?270)+
            (vec_val_271 - ?271) * (vec_val_271 - ?271)+
            (vec_val_272 - ?272) * (vec_val_272 - ?272)+
            (vec_val_273 - ?273) * (vec_val_273 - ?273)+
            (vec_val_274 - ?274) * (vec_val_274 - ?274)+
            (vec_val_275 - ?275) * (vec_val_275 - ?275)+
            (vec_val_276 - ?276) * (vec_val_276 - ?276)+
            (vec_val_277 - ?277) * (vec_val_277 - ?277)+
            (vec_val_278 - ?278) * (vec_val_278 - ?278)+
            (vec_val_279 - ?279) * (vec_val_279 - ?279)+
            (vec_val_280 - ?280) * (vec_val_280 - ?280)+
            (vec_val_281 - ?281) * (vec_val_281 - ?281)+
            (vec_val_282 - ?282) * (vec_val_282 - ?282)+
            (vec_val_283 - ?283) * (vec_val_283 - ?283)+
            (vec_val_284 - ?284) * (vec_val_284 - ?284)+
            (vec_val_285 - ?285) * (vec_val_285 - ?285)+
            (vec_val_286 - ?286) * (vec_val_286 - ?286)+
            (vec_val_287 - ?287) * (vec_val_287 - ?287)+
            (vec_val_288 - ?288) * (vec_val_288 - ?288)+
            (vec_val_289 - ?289) * (vec_val_289 - ?289)+
            (vec_val_290 - ?290) * (vec_val_290 - ?290)+
            (vec_val_291 - ?291) * (vec_val_291 - ?291)+
            (vec_val_292 - ?292) * (vec_val_292 - ?292)+
            (vec_val_293 - ?293) * (vec_val_293 - ?293)+
            (vec_val_294 - ?294) * (vec_val_294 - ?294)+
            (vec_val_295 - ?295) * (vec_val_295 - ?295)+
            (vec_val_296 - ?296) * (vec_val_296 - ?296)+
            (vec_val_297 - ?297) * (vec_val_297 - ?297)+
            (vec_val_298 - ?298) * (vec_val_298 - ?298)+
            (vec_val_299 - ?299) * (vec_val_299 - ?299)+
            (vec_val_300 - ?300) * (vec_val_300 - ?300)+
            (vec_val_301 - ?301) * (vec_val_301 - ?301)+
            (vec_val_302 - ?302) * (vec_val_302 - ?302)+
            (vec_val_303 - ?303) * (vec_val_303 - ?303)+
            (vec_val_304 - ?304) * (vec_val_304 - ?304)+
            (vec_val_305 - ?305) * (vec_val_305 - ?305)+
            (vec_val_306 - ?306) * (vec_val_306 - ?306)+
            (vec_val_307 - ?307) * (vec_val_307 - ?307)+
            (vec_val_308 - ?308) * (vec_val_308 - ?308)+
            (vec_val_309 - ?309) * (vec_val_309 - ?309)+
            (vec_val_310 - ?310) * (vec_val_310 - ?310)+
            (vec_val_311 - ?311) * (vec_val_311 - ?311)+
            (vec_val_312 - ?312) * (vec_val_312 - ?312)+
            (vec_val_313 - ?313) * (vec_val_313 - ?313)+
            (vec_val_314 - ?314) * (vec_val_314 - ?314)+
            (vec_val_315 - ?315) * (vec_val_315 - ?315)+
            (vec_val_316 - ?316) * (vec_val_316 - ?316)+
            (vec_val_317 - ?317) * (vec_val_317 - ?317)+
            (vec_val_318 - ?318) * (vec_val_318 - ?318)+
            (vec_val_319 - ?319) * (vec_val_319 - ?319)+
            (vec_val_320 - ?320) * (vec_val_320 - ?320)+
            (vec_val_321 - ?321) * (vec_val_321 - ?321)+
            (vec_val_322 - ?322) * (vec_val_322 - ?322)+
            (vec_val_323 - ?323) * (vec_val_323 - ?323)+
            (vec_val_324 - ?324) * (vec_val_324 - ?324)+
            (vec_val_325 - ?325) * (vec_val_325 - ?325)+
            (vec_val_326 - ?326) * (vec_val_326 - ?326)+
            (vec_val_327 - ?327) * (vec_val_327 - ?327)+
            (vec_val_328 - ?328) * (vec_val_328 - ?328)+
            (vec_val_329 - ?329) * (vec_val_329 - ?329)+
            (vec_val_330 - ?330) * (vec_val_330 - ?330)+
            (vec_val_331 - ?331) * (vec_val_331 - ?331)+
            (vec_val_332 - ?332) * (vec_val_332 - ?332)+
            (vec_val_333 - ?333) * (vec_val_333 - ?333)+
            (vec_val_334 - ?334) * (vec_val_334 - ?334)+
            (vec_val_335 - ?335) * (vec_val_335 - ?335)+
            (vec_val_336 - ?336) * (vec_val_336 - ?336)+
            (vec_val_337 - ?337) * (vec_val_337 - ?337)+
            (vec_val_338 - ?338) * (vec_val_338 - ?338)+
            (vec_val_339 - ?339) * (vec_val_339 - ?339)+
            (vec_val_340 - ?340) * (vec_val_340 - ?340)+
            (vec_val_341 - ?341) * (vec_val_341 - ?341)+
            (vec_val_342 - ?342) * (vec_val_342 - ?342)+
            (vec_val_343 - ?343) * (vec_val_343 - ?343)+
            (vec_val_344 - ?344) * (vec_val_344 - ?344)+
            (vec_val_345 - ?345) * (vec_val_345 - ?345)+
            (vec_val_346 - ?346) * (vec_val_346 - ?346)+
            (vec_val_347 - ?347) * (vec_val_347 - ?347)+
            (vec_val_348 - ?348) * (vec_val_348 - ?348)+
            (vec_val_349 - ?349) * (vec_val_349 - ?349)+
            (vec_val_350 - ?350) * (vec_val_350 - ?350)+
            (vec_val_351 - ?351) * (vec_val_351 - ?351)+
            (vec_val_352 - ?352) * (vec_val_352 - ?352)+
            (vec_val_353 - ?353) * (vec_val_353 - ?353)+
            (vec_val_354 - ?354) * (vec_val_354 - ?354)+
            (vec_val_355 - ?355) * (vec_val_355 - ?355)+
            (vec_val_356 - ?356) * (vec_val_356 - ?356)+
            (vec_val_357 - ?357) * (vec_val_357 - ?357)+
            (vec_val_358 - ?358) * (vec_val_358 - ?358)+
            (vec_val_359 - ?359) * (vec_val_359 - ?359)+
            (vec_val_360 - ?360) * (vec_val_360 - ?360)+
            (vec_val_361 - ?361) * (vec_val_361 - ?361)+
            (vec_val_362 - ?362) * (vec_val_362 - ?362)+
            (vec_val_363 - ?363) * (vec_val_363 - ?363)+
            (vec_val_364 - ?364) * (vec_val_364 - ?364)+
            (vec_val_365 - ?365) * (vec_val_365 - ?365)+
            (vec_val_366 - ?366) * (vec_val_366 - ?366)+
            (vec_val_367 - ?367) * (vec_val_367 - ?367)+
            (vec_val_368 - ?368) * (vec_val_368 - ?368)+
            (vec_val_369 - ?369) * (vec_val_369 - ?369)+
            (vec_val_370 - ?370) * (vec_val_370 - ?370)+
            (vec_val_371 - ?371) * (vec_val_371 - ?371)+
            (vec_val_372 - ?372) * (vec_val_372 - ?372)+
            (vec_val_373 - ?373) * (vec_val_373 - ?373)+
            (vec_val_374 - ?374) * (vec_val_374 - ?374)+
            (vec_val_375 - ?375) * (vec_val_375 - ?375)+
            (vec_val_376 - ?376) * (vec_val_376 - ?376)+
            (vec_val_377 - ?377) * (vec_val_377 - ?377)+
            (vec_val_378 - ?378) * (vec_val_378 - ?378)+
            (vec_val_379 - ?379) * (vec_val_379 - ?379)+
            (vec_val_380 - ?380) * (vec_val_380 - ?380)+
            (vec_val_381 - ?381) * (vec_val_381 - ?381)+
            (vec_val_382 - ?382) * (vec_val_382 - ?382)+
            (vec_val_383 - ?383) * (vec_val_383 - ?383)+
            (vec_val_384 - ?384) * (vec_val_384 - ?384)+
            (vec_val_385 - ?385) * (vec_val_385 - ?385)+
            (vec_val_386 - ?386) * (vec_val_386 - ?386)+
            (vec_val_387 - ?387) * (vec_val_387 - ?387)+
            (vec_val_388 - ?388) * (vec_val_388 - ?388)+
            (vec_val_389 - ?389) * (vec_val_389 - ?389)+
            (vec_val_390 - ?390) * (vec_val_390 - ?390)+
            (vec_val_391 - ?391) * (vec_val_391 - ?391)+
            (vec_val_392 - ?392) * (vec_val_392 - ?392)+
            (vec_val_393 - ?393) * (vec_val_393 - ?393)+
            (vec_val_394 - ?394) * (vec_val_394 - ?394)+
            (vec_val_395 - ?395) * (vec_val_395 - ?395)+
            (vec_val_396 - ?396) * (vec_val_396 - ?396)+
            (vec_val_397 - ?397) * (vec_val_397 - ?397)+
            (vec_val_398 - ?398) * (vec_val_398 - ?398)+
            (vec_val_399 - ?399) * (vec_val_399 - ?399)+
            (vec_val_400 - ?400) * (vec_val_400 - ?400)+
            (vec_val_401 - ?401) * (vec_val_401 - ?401)+
            (vec_val_402 - ?402) * (vec_val_402 - ?402)+
            (vec_val_403 - ?403) * (vec_val_403 - ?403)+
            (vec_val_404 - ?404) * (vec_val_404 - ?404)+
            (vec_val_405 - ?405) * (vec_val_405 - ?405)+
            (vec_val_406 - ?406) * (vec_val_406 - ?406)+
            (vec_val_407 - ?407) * (vec_val_407 - ?407)+
            (vec_val_408 - ?408) * (vec_val_408 - ?408)+
            (vec_val_409 - ?409) * (vec_val_409 - ?409)+
            (vec_val_410 - ?410) * (vec_val_410 - ?410)+
            (vec_val_411 - ?411) * (vec_val_411 - ?411)+
            (vec_val_412 - ?412) * (vec_val_412 - ?412)+
            (vec_val_413 - ?413) * (vec_val_413 - ?413)+
            (vec_val_414 - ?414) * (vec_val_414 - ?414)+
            (vec_val_415 - ?415) * (vec_val_415 - ?415)+
            (vec_val_416 - ?416) * (vec_val_416 - ?416)+
            (vec_val_417 - ?417) * (vec_val_417 - ?417)+
            (vec_val_418 - ?418) * (vec_val_418 - ?418)+
            (vec_val_419 - ?419) * (vec_val_419 - ?419)+
            (vec_val_420 - ?420) * (vec_val_420 - ?420)+
            (vec_val_421 - ?421) * (vec_val_421 - ?421)+
            (vec_val_422 - ?422) * (vec_val_422 - ?422)+
            (vec_val_423 - ?423) * (vec_val_423 - ?423)+
            (vec_val_424 - ?424) * (vec_val_424 - ?424)+
            (vec_val_425 - ?425) * (vec_val_425 - ?425)+
            (vec_val_426 - ?426) * (vec_val_426 - ?426)+
            (vec_val_427 - ?427) * (vec_val_427 - ?427)+
            (vec_val_428 - ?428) * (vec_val_428 - ?428)+
            (vec_val_429 - ?429) * (vec_val_429 - ?429)+
            (vec_val_430 - ?430) * (vec_val_430 - ?430)+
            (vec_val_431 - ?431) * (vec_val_431 - ?431)+
            (vec_val_432 - ?432) * (vec_val_432 - ?432)+
            (vec_val_433 - ?433) * (vec_val_433 - ?433)+
            (vec_val_434 - ?434) * (vec_val_434 - ?434)+
            (vec_val_435 - ?435) * (vec_val_435 - ?435)+
            (vec_val_436 - ?436) * (vec_val_436 - ?436)+
            (vec_val_437 - ?437) * (vec_val_437 - ?437)+
            (vec_val_438 - ?438) * (vec_val_438 - ?438)+
            (vec_val_439 - ?439) * (vec_val_439 - ?439)+
            (vec_val_440 - ?440) * (vec_val_440 - ?440)+
            (vec_val_441 - ?441) * (vec_val_441 - ?441)+
            (vec_val_442 - ?442) * (vec_val_442 - ?442)+
            (vec_val_443 - ?443) * (vec_val_443 - ?443)+
            (vec_val_444 - ?444) * (vec_val_444 - ?444)+
            (vec_val_445 - ?445) * (vec_val_445 - ?445)+
            (vec_val_446 - ?446) * (vec_val_446 - ?446)+
            (vec_val_447 - ?447) * (vec_val_447 - ?447)+
            (vec_val_448 - ?448) * (vec_val_448 - ?448)+
            (vec_val_449 - ?449) * (vec_val_449 - ?449)+
            (vec_val_450 - ?450) * (vec_val_450 - ?450)+
            (vec_val_451 - ?451) * (vec_val_451 - ?451)+
            (vec_val_452 - ?452) * (vec_val_452 - ?452)+
            (vec_val_453 - ?453) * (vec_val_453 - ?453)+
            (vec_val_454 - ?454) * (vec_val_454 - ?454)+
            (vec_val_455 - ?455) * (vec_val_455 - ?455)+
            (vec_val_456 - ?456) * (vec_val_456 - ?456)+
            (vec_val_457 - ?457) * (vec_val_457 - ?457)+
            (vec_val_458 - ?458) * (vec_val_458 - ?458)+
            (vec_val_459 - ?459) * (vec_val_459 - ?459)+
            (vec_val_460 - ?460) * (vec_val_460 - ?460)+
            (vec_val_461 - ?461) * (vec_val_461 - ?461)+
            (vec_val_462 - ?462) * (vec_val_462 - ?462)+
            (vec_val_463 - ?463) * (vec_val_463 - ?463)+
            (vec_val_464 - ?464) * (vec_val_464 - ?464)+
            (vec_val_465 - ?465) * (vec_val_465 - ?465)+
            (vec_val_466 - ?466) * (vec_val_466 - ?466)+
            (vec_val_467 - ?467) * (vec_val_467 - ?467)+
            (vec_val_468 - ?468) * (vec_val_468 - ?468)+
            (vec_val_469 - ?469) * (vec_val_469 - ?469)+
            (vec_val_470 - ?470) * (vec_val_470 - ?470)+
            (vec_val_471 - ?471) * (vec_val_471 - ?471)+
            (vec_val_472 - ?472) * (vec_val_472 - ?472)+
            (vec_val_473 - ?473) * (vec_val_473 - ?473)+
            (vec_val_474 - ?474) * (vec_val_474 - ?474)+
            (vec_val_475 - ?475) * (vec_val_475 - ?475)+
            (vec_val_476 - ?476) * (vec_val_476 - ?476)+
            (vec_val_477 - ?477) * (vec_val_477 - ?477)+
            (vec_val_478 - ?478) * (vec_val_478 - ?478)+
            (vec_val_479 - ?479) * (vec_val_479 - ?479)+
            (vec_val_480 - ?480) * (vec_val_480 - ?480)+
            (vec_val_481 - ?481) * (vec_val_481 - ?481)+
            (vec_val_482 - ?482) * (vec_val_482 - ?482)+
            (vec_val_483 - ?483) * (vec_val_483 - ?483)+
            (vec_val_484 - ?484) * (vec_val_484 - ?484)+
            (vec_val_485 - ?485) * (vec_val_485 - ?485)+
            (vec_val_486 - ?486) * (vec_val_486 - ?486)+
            (vec_val_487 - ?487) * (vec_val_487 - ?487)+
            (vec_val_488 - ?488) * (vec_val_488 - ?488)+
            (vec_val_489 - ?489) * (vec_val_489 - ?489)+
            (vec_val_490 - ?490) * (vec_val_490 - ?490)+
            (vec_val_491 - ?491) * (vec_val_491 - ?491)+
            (vec_val_492 - ?492) * (vec_val_492 - ?492)+
            (vec_val_493 - ?493) * (vec_val_493 - ?493)+
            (vec_val_494 - ?494) * (vec_val_494 - ?494)+
            (vec_val_495 - ?495) * (vec_val_495 - ?495)+
            (vec_val_496 - ?496) * (vec_val_496 - ?496)+
            (vec_val_497 - ?497) * (vec_val_497 - ?497)+
            (vec_val_498 - ?498) * (vec_val_498 - ?498)+
            (vec_val_499 - ?499) * (vec_val_499 - ?499)+
            (vec_val_500 - ?500) * (vec_val_500 - ?500)+
            (vec_val_501 - ?501) * (vec_val_501 - ?501)+
            (vec_val_502 - ?502) * (vec_val_502 - ?502)+
            (vec_val_503 - ?503) * (vec_val_503 - ?503)+
            (vec_val_504 - ?504) * (vec_val_504 - ?504)+
            (vec_val_505 - ?505) * (vec_val_505 - ?505)+
            (vec_val_506 - ?506) * (vec_val_506 - ?506)+
            (vec_val_507 - ?507) * (vec_val_507 - ?507)+
            (vec_val_508 - ?508) * (vec_val_508 - ?508)+
            (vec_val_509 - ?509) * (vec_val_509 - ?509)+
            (vec_val_510 - ?510) * (vec_val_510 - ?510)+
            (vec_val_511 - ?511) * (vec_val_511 - ?511)+
            (vec_val_512 - ?512) * (vec_val_512 - ?512)
            ) AS l2norm FROM faces ORDER BY l2norm ASC limit 1;
        """.trimIndent(), params
        )

        if (cursor.moveToFirst()) {
            val colId = cursor.getColumnIndex("id")
            val colUid = cursor.getColumnIndex("uid")
            val colData = cursor.getColumnIndex("data")
            val colL2Norm = cursor.getColumnIndex("l2norm")

            // Check if we don't have any rows
            if (colId == -1 || colUid == -1 || colData == -1 || colL2Norm == -1) {
                throw Exception("Invalid column names detected in database file.")
            }

            // Get data from sqlite database
            val id = cursor.getInt(colId)
            val uid = cursor.getString(colUid)
            val data = cursor.getString(colData)
            val l2norm = sqrt(cursor.getFloat(colL2Norm))

            // parse data to hashmap
//            val mapType = object : TypeToken<HashMap<String, String>>() {}.type
//            val parsedData = Gson().fromJson<HashMap<String, String>>(data, mapType)

            // return matched face data
//            cursor.close()
            return if (l2norm >= options.faceMatch.minFaceMatchThreshold && l2norm <= options.faceMatch.maxFaceMatchThreshold) {
                FaceData(id = id, uid = uid, extras = parsedData, threshold = l2norm)
            } else {
                null
            }
        }

        // close connection and raise exception in case we don't have any rows
        cursor.close()
        throw Exception("Database contains 0 rows. Please add data to predict faces.")
    }

    override suspend fun loadDatabase() {
        TODO("Not yet implemented")
    }

    override suspend fun searchVectors(vectors: Iterable<Float>, limit: Int): List<SearchVectorData> {
        TODO("Not yet implemented")
    }

    override suspend fun insertVectors(vectors: InsertVectorData) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteVectors(id: Int) {
        TODO("Not yet implemented")
    }
}