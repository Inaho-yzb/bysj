package com.yuzhaibu.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
@Controller
public abstract class BaseController {
	protected final Logger log = Logger.getLogger(this.getClass());
}
