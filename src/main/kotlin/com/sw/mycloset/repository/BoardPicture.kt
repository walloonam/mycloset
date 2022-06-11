package com.sw.mycloset.repository

import javax.persistence.Cacheable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class BoardPicture (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var Id: Long? = null,


    @Column(nullable = false)
    var fileName: String,

    @Column(nullable = false)
    var filePath: String,
    )