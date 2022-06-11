package com.sw.mycloset.repository

import org.springframework.data.repository.CrudRepository
import javax.print.DocFlavor.STRING

interface UserRepository : CrudRepository<User, Long>