package com.developbharat.facegate.domain.data

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.developbharat.facegate.Database
import tables.PeopleQueries
import tables.SearchVectorWithL2Norm
import tables.VectorsQueries
import javax.inject.Inject


class SQLiteDatabase @Inject constructor(appContext: Context) : ISQLiteDatabase {
    private val androidSqlDriver = AndroidSqliteDriver(
        schema = Database.Schema,
        context = appContext,
        name = "data.db"
    )

    override val vectorsDao: VectorsQueries = Database(androidSqlDriver).vectorsQueries;
    override val peopleDao: PeopleQueries = Database(androidSqlDriver).peopleQueries;
}

//Extension function to search vector using list.
fun VectorsQueries.searchVector(data: List<Double>): SearchVectorWithL2Norm? {
    if(data.size != 512) throw Exception("Vector search must be executed with 512 elements.")

    return this.searchVectorWithL2Norm(
        vec_val_1 = data[0],
        vec_val_2 = data[1],
        vec_val_3 = data[2],
        vec_val_4 = data[3],
        vec_val_5 = data[4],
        vec_val_6 = data[5],
        vec_val_7 = data[6],
        vec_val_8 = data[7],
        vec_val_9 = data[8],
        vec_val_10 = data[9],
        vec_val_11 = data[10],
        vec_val_12 = data[11],
        vec_val_13 = data[12],
        vec_val_14 = data[13],
        vec_val_15 = data[14],
        vec_val_16 = data[15],
        vec_val_17 = data[16],
        vec_val_18 = data[17],
        vec_val_19 = data[18],
        vec_val_20 = data[19],
        vec_val_21 = data[20],
        vec_val_22 = data[21],
        vec_val_23 = data[22],
        vec_val_24 = data[23],
        vec_val_25 = data[24],
        vec_val_26 = data[25],
        vec_val_27 = data[26],
        vec_val_28 = data[27],
        vec_val_29 = data[28],
        vec_val_30 = data[29],
        vec_val_31 = data[30],
        vec_val_32 = data[31],
        vec_val_33 = data[32],
        vec_val_34 = data[33],
        vec_val_35 = data[34],
        vec_val_36 = data[35],
        vec_val_37 = data[36],
        vec_val_38 = data[37],
        vec_val_39 = data[38],
        vec_val_40 = data[39],
        vec_val_41 = data[40],
        vec_val_42 = data[41],
        vec_val_43 = data[42],
        vec_val_44 = data[43],
        vec_val_45 = data[44],
        vec_val_46 = data[45],
        vec_val_47 = data[46],
        vec_val_48 = data[47],
        vec_val_49 = data[48],
        vec_val_50 = data[49],
        vec_val_51 = data[50],
        vec_val_52 = data[51],
        vec_val_53 = data[52],
        vec_val_54 = data[53],
        vec_val_55 = data[54],
        vec_val_56 = data[55],
        vec_val_57 = data[56],
        vec_val_58 = data[57],
        vec_val_59 = data[58],
        vec_val_60 = data[59],
        vec_val_61 = data[60],
        vec_val_62 = data[61],
        vec_val_63 = data[62],
        vec_val_64 = data[63],
        vec_val_65 = data[64],
        vec_val_66 = data[65],
        vec_val_67 = data[66],
        vec_val_68 = data[67],
        vec_val_69 = data[68],
        vec_val_70 = data[69],
        vec_val_71 = data[70],
        vec_val_72 = data[71],
        vec_val_73 = data[72],
        vec_val_74 = data[73],
        vec_val_75 = data[74],
        vec_val_76 = data[75],
        vec_val_77 = data[76],
        vec_val_78 = data[77],
        vec_val_79 = data[78],
        vec_val_80 = data[79],
        vec_val_81 = data[80],
        vec_val_82 = data[81],
        vec_val_83 = data[82],
        vec_val_84 = data[83],
        vec_val_85 = data[84],
        vec_val_86 = data[85],
        vec_val_87 = data[86],
        vec_val_88 = data[87],
        vec_val_89 = data[88],
        vec_val_90 = data[89],
        vec_val_91 = data[90],
        vec_val_92 = data[91],
        vec_val_93 = data[92],
        vec_val_94 = data[93],
        vec_val_95 = data[94],
        vec_val_96 = data[95],
        vec_val_97 = data[96],
        vec_val_98 = data[97],
        vec_val_99 = data[98],
        vec_val_100 = data[99],
        vec_val_101 = data[100],
        vec_val_102 = data[101],
        vec_val_103 = data[102],
        vec_val_104 = data[103],
        vec_val_105 = data[104],
        vec_val_106 = data[105],
        vec_val_107 = data[106],
        vec_val_108 = data[107],
        vec_val_109 = data[108],
        vec_val_110 = data[109],
        vec_val_111 = data[110],
        vec_val_112 = data[111],
        vec_val_113 = data[112],
        vec_val_114 = data[113],
        vec_val_115 = data[114],
        vec_val_116 = data[115],
        vec_val_117 = data[116],
        vec_val_118 = data[117],
        vec_val_119 = data[118],
        vec_val_120 = data[119],
        vec_val_121 = data[120],
        vec_val_122 = data[121],
        vec_val_123 = data[122],
        vec_val_124 = data[123],
        vec_val_125 = data[124],
        vec_val_126 = data[125],
        vec_val_127 = data[126],
        vec_val_128 = data[127],
        vec_val_129 = data[128],
        vec_val_130 = data[129],
        vec_val_131 = data[130],
        vec_val_132 = data[131],
        vec_val_133 = data[132],
        vec_val_134 = data[133],
        vec_val_135 = data[134],
        vec_val_136 = data[135],
        vec_val_137 = data[136],
        vec_val_138 = data[137],
        vec_val_139 = data[138],
        vec_val_140 = data[139],
        vec_val_141 = data[140],
        vec_val_142 = data[141],
        vec_val_143 = data[142],
        vec_val_144 = data[143],
        vec_val_145 = data[144],
        vec_val_146 = data[145],
        vec_val_147 = data[146],
        vec_val_148 = data[147],
        vec_val_149 = data[148],
        vec_val_150 = data[149],
        vec_val_151 = data[150],
        vec_val_152 = data[151],
        vec_val_153 = data[152],
        vec_val_154 = data[153],
        vec_val_155 = data[154],
        vec_val_156 = data[155],
        vec_val_157 = data[156],
        vec_val_158 = data[157],
        vec_val_159 = data[158],
        vec_val_160 = data[159],
        vec_val_161 = data[160],
        vec_val_162 = data[161],
        vec_val_163 = data[162],
        vec_val_164 = data[163],
        vec_val_165 = data[164],
        vec_val_166 = data[165],
        vec_val_167 = data[166],
        vec_val_168 = data[167],
        vec_val_169 = data[168],
        vec_val_170 = data[169],
        vec_val_171 = data[170],
        vec_val_172 = data[171],
        vec_val_173 = data[172],
        vec_val_174 = data[173],
        vec_val_175 = data[174],
        vec_val_176 = data[175],
        vec_val_177 = data[176],
        vec_val_178 = data[177],
        vec_val_179 = data[178],
        vec_val_180 = data[179],
        vec_val_181 = data[180],
        vec_val_182 = data[181],
        vec_val_183 = data[182],
        vec_val_184 = data[183],
        vec_val_185 = data[184],
        vec_val_186 = data[185],
        vec_val_187 = data[186],
        vec_val_188 = data[187],
        vec_val_189 = data[188],
        vec_val_190 = data[189],
        vec_val_191 = data[190],
        vec_val_192 = data[191],
        vec_val_193 = data[192],
        vec_val_194 = data[193],
        vec_val_195 = data[194],
        vec_val_196 = data[195],
        vec_val_197 = data[196],
        vec_val_198 = data[197],
        vec_val_199 = data[198],
        vec_val_200 = data[199],
        vec_val_201 = data[200],
        vec_val_202 = data[201],
        vec_val_203 = data[202],
        vec_val_204 = data[203],
        vec_val_205 = data[204],
        vec_val_206 = data[205],
        vec_val_207 = data[206],
        vec_val_208 = data[207],
        vec_val_209 = data[208],
        vec_val_210 = data[209],
        vec_val_211 = data[210],
        vec_val_212 = data[211],
        vec_val_213 = data[212],
        vec_val_214 = data[213],
        vec_val_215 = data[214],
        vec_val_216 = data[215],
        vec_val_217 = data[216],
        vec_val_218 = data[217],
        vec_val_219 = data[218],
        vec_val_220 = data[219],
        vec_val_221 = data[220],
        vec_val_222 = data[221],
        vec_val_223 = data[222],
        vec_val_224 = data[223],
        vec_val_225 = data[224],
        vec_val_226 = data[225],
        vec_val_227 = data[226],
        vec_val_228 = data[227],
        vec_val_229 = data[228],
        vec_val_230 = data[229],
        vec_val_231 = data[230],
        vec_val_232 = data[231],
        vec_val_233 = data[232],
        vec_val_234 = data[233],
        vec_val_235 = data[234],
        vec_val_236 = data[235],
        vec_val_237 = data[236],
        vec_val_238 = data[237],
        vec_val_239 = data[238],
        vec_val_240 = data[239],
        vec_val_241 = data[240],
        vec_val_242 = data[241],
        vec_val_243 = data[242],
        vec_val_244 = data[243],
        vec_val_245 = data[244],
        vec_val_246 = data[245],
        vec_val_247 = data[246],
        vec_val_248 = data[247],
        vec_val_249 = data[248],
        vec_val_250 = data[249],
        vec_val_251 = data[250],
        vec_val_252 = data[251],
        vec_val_253 = data[252],
        vec_val_254 = data[253],
        vec_val_255 = data[254],
        vec_val_256 = data[255],
        vec_val_257 = data[256],
        vec_val_258 = data[257],
        vec_val_259 = data[258],
        vec_val_260 = data[259],
        vec_val_261 = data[260],
        vec_val_262 = data[261],
        vec_val_263 = data[262],
        vec_val_264 = data[263],
        vec_val_265 = data[264],
        vec_val_266 = data[265],
        vec_val_267 = data[266],
        vec_val_268 = data[267],
        vec_val_269 = data[268],
        vec_val_270 = data[269],
        vec_val_271 = data[270],
        vec_val_272 = data[271],
        vec_val_273 = data[272],
        vec_val_274 = data[273],
        vec_val_275 = data[274],
        vec_val_276 = data[275],
        vec_val_277 = data[276],
        vec_val_278 = data[277],
        vec_val_279 = data[278],
        vec_val_280 = data[279],
        vec_val_281 = data[280],
        vec_val_282 = data[281],
        vec_val_283 = data[282],
        vec_val_284 = data[283],
        vec_val_285 = data[284],
        vec_val_286 = data[285],
        vec_val_287 = data[286],
        vec_val_288 = data[287],
        vec_val_289 = data[288],
        vec_val_290 = data[289],
        vec_val_291 = data[290],
        vec_val_292 = data[291],
        vec_val_293 = data[292],
        vec_val_294 = data[293],
        vec_val_295 = data[294],
        vec_val_296 = data[295],
        vec_val_297 = data[296],
        vec_val_298 = data[297],
        vec_val_299 = data[298],
        vec_val_300 = data[299],
        vec_val_301 = data[300],
        vec_val_302 = data[301],
        vec_val_303 = data[302],
        vec_val_304 = data[303],
        vec_val_305 = data[304],
        vec_val_306 = data[305],
        vec_val_307 = data[306],
        vec_val_308 = data[307],
        vec_val_309 = data[308],
        vec_val_310 = data[309],
        vec_val_311 = data[310],
        vec_val_312 = data[311],
        vec_val_313 = data[312],
        vec_val_314 = data[313],
        vec_val_315 = data[314],
        vec_val_316 = data[315],
        vec_val_317 = data[316],
        vec_val_318 = data[317],
        vec_val_319 = data[318],
        vec_val_320 = data[319],
        vec_val_321 = data[320],
        vec_val_322 = data[321],
        vec_val_323 = data[322],
        vec_val_324 = data[323],
        vec_val_325 = data[324],
        vec_val_326 = data[325],
        vec_val_327 = data[326],
        vec_val_328 = data[327],
        vec_val_329 = data[328],
        vec_val_330 = data[329],
        vec_val_331 = data[330],
        vec_val_332 = data[331],
        vec_val_333 = data[332],
        vec_val_334 = data[333],
        vec_val_335 = data[334],
        vec_val_336 = data[335],
        vec_val_337 = data[336],
        vec_val_338 = data[337],
        vec_val_339 = data[338],
        vec_val_340 = data[339],
        vec_val_341 = data[340],
        vec_val_342 = data[341],
        vec_val_343 = data[342],
        vec_val_344 = data[343],
        vec_val_345 = data[344],
        vec_val_346 = data[345],
        vec_val_347 = data[346],
        vec_val_348 = data[347],
        vec_val_349 = data[348],
        vec_val_350 = data[349],
        vec_val_351 = data[350],
        vec_val_352 = data[351],
        vec_val_353 = data[352],
        vec_val_354 = data[353],
        vec_val_355 = data[354],
        vec_val_356 = data[355],
        vec_val_357 = data[356],
        vec_val_358 = data[357],
        vec_val_359 = data[358],
        vec_val_360 = data[359],
        vec_val_361 = data[360],
        vec_val_362 = data[361],
        vec_val_363 = data[362],
        vec_val_364 = data[363],
        vec_val_365 = data[364],
        vec_val_366 = data[365],
        vec_val_367 = data[366],
        vec_val_368 = data[367],
        vec_val_369 = data[368],
        vec_val_370 = data[369],
        vec_val_371 = data[370],
        vec_val_372 = data[371],
        vec_val_373 = data[372],
        vec_val_374 = data[373],
        vec_val_375 = data[374],
        vec_val_376 = data[375],
        vec_val_377 = data[376],
        vec_val_378 = data[377],
        vec_val_379 = data[378],
        vec_val_380 = data[379],
        vec_val_381 = data[380],
        vec_val_382 = data[381],
        vec_val_383 = data[382],
        vec_val_384 = data[383],
        vec_val_385 = data[384],
        vec_val_386 = data[385],
        vec_val_387 = data[386],
        vec_val_388 = data[387],
        vec_val_389 = data[388],
        vec_val_390 = data[389],
        vec_val_391 = data[390],
        vec_val_392 = data[391],
        vec_val_393 = data[392],
        vec_val_394 = data[393],
        vec_val_395 = data[394],
        vec_val_396 = data[395],
        vec_val_397 = data[396],
        vec_val_398 = data[397],
        vec_val_399 = data[398],
        vec_val_400 = data[399],
        vec_val_401 = data[400],
        vec_val_402 = data[401],
        vec_val_403 = data[402],
        vec_val_404 = data[403],
        vec_val_405 = data[404],
        vec_val_406 = data[405],
        vec_val_407 = data[406],
        vec_val_408 = data[407],
        vec_val_409 = data[408],
        vec_val_410 = data[409],
        vec_val_411 = data[410],
        vec_val_412 = data[411],
        vec_val_413 = data[412],
        vec_val_414 = data[413],
        vec_val_415 = data[414],
        vec_val_416 = data[415],
        vec_val_417 = data[416],
        vec_val_418 = data[417],
        vec_val_419 = data[418],
        vec_val_420 = data[419],
        vec_val_421 = data[420],
        vec_val_422 = data[421],
        vec_val_423 = data[422],
        vec_val_424 = data[423],
        vec_val_425 = data[424],
        vec_val_426 = data[425],
        vec_val_427 = data[426],
        vec_val_428 = data[427],
        vec_val_429 = data[428],
        vec_val_430 = data[429],
        vec_val_431 = data[430],
        vec_val_432 = data[431],
        vec_val_433 = data[432],
        vec_val_434 = data[433],
        vec_val_435 = data[434],
        vec_val_436 = data[435],
        vec_val_437 = data[436],
        vec_val_438 = data[437],
        vec_val_439 = data[438],
        vec_val_440 = data[439],
        vec_val_441 = data[440],
        vec_val_442 = data[441],
        vec_val_443 = data[442],
        vec_val_444 = data[443],
        vec_val_445 = data[444],
        vec_val_446 = data[445],
        vec_val_447 = data[446],
        vec_val_448 = data[447],
        vec_val_449 = data[448],
        vec_val_450 = data[449],
        vec_val_451 = data[450],
        vec_val_452 = data[451],
        vec_val_453 = data[452],
        vec_val_454 = data[453],
        vec_val_455 = data[454],
        vec_val_456 = data[455],
        vec_val_457 = data[456],
        vec_val_458 = data[457],
        vec_val_459 = data[458],
        vec_val_460 = data[459],
        vec_val_461 = data[460],
        vec_val_462 = data[461],
        vec_val_463 = data[462],
        vec_val_464 = data[463],
        vec_val_465 = data[464],
        vec_val_466 = data[465],
        vec_val_467 = data[466],
        vec_val_468 = data[467],
        vec_val_469 = data[468],
        vec_val_470 = data[469],
        vec_val_471 = data[470],
        vec_val_472 = data[471],
        vec_val_473 = data[472],
        vec_val_474 = data[473],
        vec_val_475 = data[474],
        vec_val_476 = data[475],
        vec_val_477 = data[476],
        vec_val_478 = data[477],
        vec_val_479 = data[478],
        vec_val_480 = data[479],
        vec_val_481 = data[480],
        vec_val_482 = data[481],
        vec_val_483 = data[482],
        vec_val_484 = data[483],
        vec_val_485 = data[484],
        vec_val_486 = data[485],
        vec_val_487 = data[486],
        vec_val_488 = data[487],
        vec_val_489 = data[488],
        vec_val_490 = data[489],
        vec_val_491 = data[490],
        vec_val_492 = data[491],
        vec_val_493 = data[492],
        vec_val_494 = data[493],
        vec_val_495 = data[494],
        vec_val_496 = data[495],
        vec_val_497 = data[496],
        vec_val_498 = data[497],
        vec_val_499 = data[498],
        vec_val_500 = data[499],
        vec_val_501 = data[500],
        vec_val_502 = data[501],
        vec_val_503 = data[502],
        vec_val_504 = data[503],
        vec_val_505 = data[504],
        vec_val_506 = data[505],
        vec_val_507 = data[506],
        vec_val_508 = data[507],
        vec_val_509 = data[508],
        vec_val_510 = data[509],
        vec_val_511 = data[510],
        vec_val_512 = data[511]
    ).executeAsOneOrNull()
}