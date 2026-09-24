package com.hasantuncay.mobsec.core.auditor

import com.hasantuncay.mobsec.core.auditor.engine.AuditorReducer as EngineReducer
import com.hasantuncay.mobsec.core.auditor.engine.TransitionResult as EngineTransitionResult
import com.hasantuncay.mobsec.core.auditor.validator.AuditorTreeValidator as TreeValidator
import com.hasantuncay.mobsec.core.auditor.validator.ValidationResult as ValidatorResult

typealias AuditorReducer = EngineReducer
typealias TransitionResult = EngineTransitionResult
typealias AuditorTreeValidator = TreeValidator
typealias ValidationResult = ValidatorResult
