package com.sw.mycloset.repository

import java.awt.Image
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Clothes (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,

    @Column(nullable = false)
    var clothesName: String,

    @Column(nullable = false)
    var clothesCloset: String,

    @Column(nullable= false)
    var clothesCategory: String,

    @Column(nullable = false)
    var clothesBuy: Date,

    @Column(nullable = false)
    var clothesSeason: String


)

//이름 옷장 카테고리 구매일자 계절  사진