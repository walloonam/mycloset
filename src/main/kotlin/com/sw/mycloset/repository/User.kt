package com.sw.mycloset.repository

import lombok.Data
import javax.persistence.*

@Data
@Entity
class User(
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Long? = null,


    @Column(nullable = false)
    var userEmail: String,

    @Column(nullable = false)
    var userName: String,

    @Column(nullable = false)
    var userPwd: String,
)