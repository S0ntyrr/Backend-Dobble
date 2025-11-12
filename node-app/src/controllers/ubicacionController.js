const { Ubicacion } = require('../models');
exports.getAll = async (req, res) => res.json(await Ubicacion.findAll());
exports.getById = async (req, res) => { const u = await Ubicacion.findByPk(req.params.id); if(!u) return res.status(404).json({msg:'No encontrado'}); res.json(u); };
exports.create = async (req, res) => res.status(201).json(await Ubicacion.create(req.body));
exports.update = async (req, res) => { const u = await Ubicacion.findByPk(req.params.id); if(!u) return res.status(404).json({msg:'No encontrado'}); await u.update(req.body); res.json(u); };
exports.remove = async (req, res) => { const u = await Ubicacion.findByPk(req.params.id); if(!u) return res.status(404).json({msg:'No encontrado'}); await u.destroy(); res.status(204).send(); };
