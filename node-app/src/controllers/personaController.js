const { Persona } = require('../models');
exports.getAll = async (req, res) => { const items = await Persona.findAll(); res.json(items); };
exports.getById = async (req, res) => { const item = await Persona.findByPk(req.params.id); if(!item) return res.status(404).json({msg:'No encontrado'}); res.json(item); };
exports.create = async (req, res) => { const created = await Persona.create(req.body); res.status(201).json(created); };
exports.update = async (req, res) => { const item = await Persona.findByPk(req.params.id); if(!item) return res.status(404).json({msg:'No encontrado'}); await item.update(req.body); res.json(item); };
exports.remove = async (req, res) => { const item = await Persona.findByPk(req.params.id); if(!item) return res.status(404).json({msg:'No encontrado'}); await item.destroy(); res.status(204).send(); };
