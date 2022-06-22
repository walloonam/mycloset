package com.sw.mycloset.repository

import org.hibernate.annotations.ColumnDefault
import javax.persistence.*

@Entity
class Closet (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var closetUser: String,

    @Column(nullable = false)
    var closetName: String,

    @Column(nullable = false)
    @ColumnDefault("false")
    var priorty: Boolean,

)