package com.sw.mycloset.repository

import org.springframework.data.repository.CrudRepository

interface ClothesRepository : CrudRepository<Clothes, Long>
